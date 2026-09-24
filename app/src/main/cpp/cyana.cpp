#include <jni.h>
#include <android/asset_manager_jni.h>
#include <android/asset_manager.h>
#include "WavParser.h"
#include "Sample.h"
#include "AudioEngine.h"
#include <android/log.h>

#define LOG_TAG "Cyana"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

AudioEngine audioEngine;

extern "C"
JNIEXPORT void JNICALL
Java_dev_dhanushgowda_cyana_jni_DrumMachine_loadSamples(JNIEnv *env, jobject thiz, jobject asset_manager) {
    AAssetManager* manager = AAssetManager_fromJava(env, asset_manager);

    Sample kick = Sample(1, WavParser::getPcmDataByFilename("kick.wav", manager));
    Sample snare = Sample(2, WavParser::getPcmDataByFilename("snare.wav", manager));
    Sample openHat = Sample(3, WavParser::getPcmDataByFilename("openHat.wav", manager));
    Sample closedHat = Sample(4, WavParser::getPcmDataByFilename("closedHat.wav", manager));
    Sample floorTom = Sample(5, WavParser::getPcmDataByFilename("floorTom.wav", manager));
    Sample midTom = Sample(6, WavParser::getPcmDataByFilename("midTom.wav", manager));
    Sample highTom = Sample(7, WavParser::getPcmDataByFilename("highTom.wav", manager));
    Sample crash = Sample(8, WavParser::getPcmDataByFilename("crash.wav", manager));

    audioEngine.insertSample(kick);
    audioEngine.insertSample(snare);
    audioEngine.insertSample(openHat);
    audioEngine.insertSample(closedHat);
    audioEngine.insertSample(floorTom);
    audioEngine.insertSample(midTom);
    audioEngine.insertSample(highTom);
    audioEngine.insertSample(crash);

    audioEngine.openStream();
}
extern "C"
JNIEXPORT void JNICALL
Java_dev_dhanushgowda_cyana_jni_DrumMachine_playPad(JNIEnv *env, jobject thiz, jint id) {
    audioEngine.playSampleById(id);
}