//
// Created by DHANUSH GOWDA K R on 24/09/26.
//


#include <android/log.h>
#include "AudioEngine.h"
void AudioEngine::openStream() {
    oboe::AudioStreamBuilder builder;
    builder.setFormat(oboe::AudioFormat::Float);
    builder.setSharingMode(oboe::SharingMode::Exclusive);
    builder.setSampleRate(44100);
    builder.setChannelCount(2);
    builder.setCallback(this);
    builder.setPerformanceMode(oboe::PerformanceMode::LowLatency);
    builder.setDirection(oboe::Direction::Output);
    auto result = builder.openStream(&stream);
    if (result != oboe::Result::OK) {
        return;
    }
    stream->setBufferSizeInFrames(stream->getFramesPerBurst()*2);
    stream->requestStart();

}

oboe::DataCallbackResult AudioEngine::onAudioReady(oboe::AudioStream *audioStream, void *audioData, int32_t numFrames) {
    float *output = static_cast<float *> (audioData);

    //clear buffer
    std::fill(output, output + numFrames*2, 0.0f);

    for (Voice& voice: voices) {
        if (!voice.isPlaying()) {
            continue;
        }
        const std::vector<float>& data = voice.getSample()->getPcmData();
        for (int32_t frame = 0; frame < numFrames; frame++) {
            size_t position = voice.getPosition();
            if (position * 2 + 1 >= data.size()) {
                voice.stop();
                break;
            }
            float left = data[position * 2];
            float right = data[position * 2 + 1];
            output[frame*2] += left;
            output[frame*2+1] += right;
            voice.advance(1);
        }
    }

    return oboe::DataCallbackResult::Continue;
}

void AudioEngine::insertSample(Sample& sample) {
    samples.push_back(sample);
}

Sample& AudioEngine::findSampleById(int sampleId) {
    for (Sample& sample : samples) {
        if (sample.getSampleId() == sampleId) {
            return sample;
        }
    }
    throw std::runtime_error("Sample not found");
}

void AudioEngine::playSampleById(int sampleId) {
    Sample& sample = findSampleById(sampleId);
    voices.emplace_back(&sample, true, 0);
}
