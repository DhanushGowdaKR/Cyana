//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#include "WavParser.h"
//#include "string"
std::vector<float> WavParser::getPcmData(const void* buffer, size_t size) {
    const uint8_t* data = static_cast<const uint8_t*> (buffer);
    std::vector<float> pcmData;
    //find data chunk
    size_t position = 0;
    while (position + 8 <= size) {
        if (memcmp(data + position, "data", 4) == 0) {
            uint32_t dataChunkSize;
            memcpy(&dataChunkSize, data + position + 4, sizeof(uint32_t));

            size_t pcmStart = position + 8;
            if (pcmStart + dataChunkSize > size) {
                return {};
            }
            for (size_t i = 0; i < dataChunkSize; i = i+2) {
//                float sample;
                int16_t sample16;
                std::memcpy(&sample16, data + pcmStart + i, sizeof(int16_t));

                float sample = static_cast<float>(sample16) / 32768.0f;

                pcmData.push_back(sample);
            }
        }
        position++;
    }
    return pcmData;
}

std::vector<float> WavParser::getPcmDataByFilename(const std::string& filename, AAssetManager *manager) {
    AAsset* asset = AAssetManager_open(manager, filename.c_str(), AASSET_MODE_BUFFER);

    if (asset == nullptr) {
        return {};
    }
    const void* buffer = AAsset_getBuffer(asset);
    size_t size = AAsset_getLength(asset);
    return getPcmData(buffer, size);
}
