//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#ifndef CYANA_VOICE_H
#define CYANA_VOICE_H
#include "Sample.h"

class Voice {
    Sample* sample;
    bool playing;
    size_t position;
public:
    Voice(Sample* sample, bool playing, size_t position) : sample(sample), playing(playing), position(position) {}

    const Sample* getSample() const {
        return sample;
    }
    bool isPlaying() const {
        return playing;
    }
    size_t getPosition() const {
        return position;
    }
    void advance(size_t amount) {
        position += amount;
    }

    void stop() {
        playing = false;

    }
};


#endif //CYANA_VOICE_H
