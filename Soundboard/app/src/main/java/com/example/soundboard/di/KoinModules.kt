package com.example.soundboard.di

import com.example.soundboard.sounds.SoundPoolPlayer
import com.example.soundboard.ui.SoundboardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<SoundboardViewModel> { SoundboardViewModel(get()) }
}

val appModule = module {
    single<SoundPoolPlayer> { SoundPoolPlayer(androidContext()) }
}