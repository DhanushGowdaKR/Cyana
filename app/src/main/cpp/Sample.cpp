//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#include "Sample.h"

int Sample::getSampleId() const {
    return sampleId;
}

const std::vector<float> &Sample::getPcmData() const {
    return pcmData;
}
