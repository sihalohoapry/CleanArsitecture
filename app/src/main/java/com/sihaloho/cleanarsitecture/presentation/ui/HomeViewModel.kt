package com.sihaloho.cleanarsitecture.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sihaloho.cleanarsitecture.domain.usecase.MainUseCase

class HomeViewModel(private val useCase: MainUseCase) : ViewModel() {
    val getListGame = useCase.getListGame().asLiveData()
}