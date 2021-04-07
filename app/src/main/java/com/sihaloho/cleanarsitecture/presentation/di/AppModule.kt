package com.sihaloho.cleanarsitecture.presentation.di

import com.sihaloho.cleanarsitecture.domain.usecase.MainInteractor
import com.sihaloho.cleanarsitecture.domain.usecase.MainUseCase
import com.sihaloho.cleanarsitecture.presentation.ui.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MainUseCase> { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get())  }
}