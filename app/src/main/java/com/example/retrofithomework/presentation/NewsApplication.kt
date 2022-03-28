package com.example.retrofithomework.presentation

import android.app.Application
import com.example.retrofithomework.data.di.dataModule
import com.example.retrofithomework.domain.di.modelModule
import com.example.retrofithomework.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    modelModule,
                    dataModule
                )
            )
        }
    }
}