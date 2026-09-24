//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#ifndef CYANA_WAVPARSER_H
#define CYANA_WAVPARSER_H
#include <string>
#include <vector>
#include <android/asset_manager.h>


class WavParser {
    static std::vector<float> getPcmData(const void* buffer, size_t size);
public:
    static std::vector<float> getPcmDataByFilename(const std::string& filename, AAssetManager* manager);
};


#endif //CYANA_WAVPARSER_H
