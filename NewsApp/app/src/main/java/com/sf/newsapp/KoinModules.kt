package com.sf.newsapp

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinModules = module {
    viewModel {
        NewsViewModel(get())
    }
    single {
        NewsRepository()
    }
}