package com.example.soundboard

import android.app.Application
import android.content.Context
import com.example.soundboard.di.appModule
import com.example.soundboard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Soundboard : Application()  {

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
        startKoin{
            androidContext(this@Soundboard)
            modules(appModule, viewModelModule)
        }
    }

    //cak ne treba zbog koina
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
}