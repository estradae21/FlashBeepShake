package com.ernestoestrada.flashbeepshake


import android.media.AudioManager
import android.media.ToneGenerator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.cameraManager
import org.jetbrains.anko.vibrator

class Main_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashBtn?.setOnCheckedChangeListener { buttonView, isChecked ->
            var camera = cameraManager.cameraIdList
            var flash = camera[0]
            if (isChecked) {
                cameraManager.setTorchMode(flash, true)
            }
            else {
                cameraManager.setTorchMode(flash, false)
            }
        }

        beepBtn.setOnClickListener {
            val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            tone.startTone(ToneGenerator.TONE_DTMF_3,600)	//play specific tone for 600ms
        }

        shakeBtn.setOnClickListener {
            val vib = vibrator
            vib.vibrate(600)
        }
    }
}
