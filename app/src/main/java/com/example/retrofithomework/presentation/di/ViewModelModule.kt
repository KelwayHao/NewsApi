package com.example.retrofithomework.presentation.di

import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() {
        NewsViewModel(
            get()
        )
    }
}