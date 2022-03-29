package com.example.retrofithomework.domain.di

import com.example.retrofithomework.data.NewsRepositoryImpl
import com.example.retrofithomework.data.retrofit.RetrofitClient
import com.example.retrofithomework.domain.interactor.NewsInteractor
import com.example.retrofithomework.domain.interactor.NewsInteractorImpl
import com.example.retrofithomework.domain.repository.NewsRepository
import org.koin.dsl.module

val modelModule = module {
    single<NewsInteractor> {
        NewsInteractorImpl(
            get()
        )
    }

    single<NewsRepository> {
        NewsRepositoryImpl(
            RetrofitClient.getNewsApi()
        )
    }
}