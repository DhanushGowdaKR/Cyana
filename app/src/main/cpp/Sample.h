//
// Created by DHANUSH GOWDA K R on 24/09/26.
//

#ifndef CYANA_SAMPLE_H
#define CYANA_SAMPLE_H
#include <vector>

class Sample {
private:
    int sampleId;
    std::vector<float> pcmData;

public:
    Sample(int sampleId, std::vector<float> pcmData) : sampleId(sampleId), pcmData(std::move(pcmData)) {}

    int getSampleId() const;
    const std::vector<float>& getPcmData() const;
};


#endif //CYANA_SAMPLE_H
