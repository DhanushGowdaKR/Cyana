package dev.dhanushgowda.cyana.jni

import android.content.res.AssetManager

class DrumMachine {
    companion object {
        init {
            System.loadLibrary("cyana")
        }
    }
    external fun loadSamples(assetManager: AssetManager)
    external fun playPad(id: Int)
}