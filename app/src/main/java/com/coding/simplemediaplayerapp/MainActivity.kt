package com.coding.simplemediaplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this,R.raw.song)


        val stopBtn = findViewById<Button>(R.id.stopBtn)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val pauseBtn = findViewById<Button>(R.id.pauseBtn)

        playBtn.setOnClickListener {
            mediaPlayer.start()
        }
        pauseBtn.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
            }
        }
        stopBtn.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()

                mediaPlayer.prepare()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }
    }
}