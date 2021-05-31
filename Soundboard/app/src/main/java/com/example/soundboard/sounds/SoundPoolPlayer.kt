package com.example.soundboard.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.widget.Toast
import com.example.soundboard.R
import com.example.soundboard.Soundboard

class SoundPoolPlayer(private val context: Context) {

    private val soundPool : SoundPool
    private val mamicSoundId: Int
    private val muskSoundId: Int
    private val zuckerbergSoundId: Int

    private val priority: Int = 1
    private val maxStreams: Int = 1

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    init{
        soundPool = if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build()
            SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build()
        } else {
            SoundPool(maxStreams, AudioManager.USE_DEFAULT_STREAM_TYPE, 1)
        }

        mamicSoundId = soundPool.load(context, R.raw.mamic,priority)
        muskSoundId = soundPool.load(context, R.raw.musk,priority)
        zuckerbergSoundId = soundPool.load(context, R.raw.zuckerberg,priority)
    }

    fun playSound(personClickedResource: Int){
        when(personClickedResource){
            R.id.ibMamic -> soundPool.play(mamicSoundId, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
            R.id.ibMusk -> soundPool.play(muskSoundId, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
            R.id.ibZuckerberg -> soundPool.play(zuckerbergSoundId, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
            else -> Toast.makeText(context,"Something's wrong!",Toast.LENGTH_SHORT).show()
        }
    }
}