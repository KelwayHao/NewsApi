package com.example.retrofithomework.presentation

import android.app.Application
import com.example.retrofithomework.domain.di.modelModule
import com.example.retrofithomework.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class KoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    modelModule
                )
            )
        }
    }
}