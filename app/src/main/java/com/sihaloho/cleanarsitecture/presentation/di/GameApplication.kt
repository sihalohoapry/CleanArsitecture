package com.sihaloho.cleanarsitecture.presentation.di

import android.app.Application
import com.sihaloho.cleanarsitecture.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GameApplication : Application() {

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@GameApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

}