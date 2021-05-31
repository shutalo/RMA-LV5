package com.example.soundboard.ui

import androidx.lifecycle.ViewModel
import com.example.soundboard.sounds.SoundPoolPlayer

class SoundboardViewModel(private val soundPool: SoundPoolPlayer) : ViewModel() {

    fun playSound(personClickedResource: Int){
        soundPool.playSound(personClickedResource)
    }
}