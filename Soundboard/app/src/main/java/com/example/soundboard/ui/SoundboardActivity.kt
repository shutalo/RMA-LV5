package com.example.soundboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.soundboard.R
import com.example.soundboard.databinding.ActivitySoundboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SoundboardActivity : AppCompatActivity()  {

    private lateinit var binding: ActivitySoundboardBinding
    private val viewModel by viewModel<SoundboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoundboardBinding.inflate(layoutInflater).also { it ->
            it.ibMamic.setOnClickListener{
                viewModel.playSound(it.id)
            }
            it.ibMusk.setOnClickListener{
                viewModel.playSound(it.id)
            }
            it.ibZuckerberg.setOnClickListener{
                viewModel.playSound(it.id)
            }
            setContentView(it.root)
        }
    }
}