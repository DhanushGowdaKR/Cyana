package dev.dhanushgowda.cyana.jni

import android.content.res.AssetManager

class DrumMachine {
    external fun loadSamples(assetManager: AssetManager)
    external fun playPad(id: Int)
}