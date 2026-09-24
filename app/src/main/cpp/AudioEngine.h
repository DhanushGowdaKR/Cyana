//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#ifndef CYANA_AUDIOENGINE_H
#define CYANA_AUDIOENGINE_H
#include <oboe/Oboe.h>
#include <vector>
#include "Voice.h"
#include "Sample.h"

class AudioEngine : public oboe::AudioStreamCallback {
    oboe::DataCallbackResult onAudioReady(oboe::AudioStream *audioStream, void *audioData, int32_t numFrames) override;
    std::vector<Sample> samples;
    std::vector<Voice> voices;
public:
    oboe::AudioStream* stream = nullptr;
    void openStream();
    void insertSample(Sample& sample);
    void playSampleById(int sampleId);
    Sample& findSampleById(int sampleId);
};


#endif //CYANA_AUDIOENGINE_H
