package com.example.retrofithomework.data.di

import com.example.retrofithomework.data.retrofit.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single {
        RetrofitClient.getNewsApi()
    }
}