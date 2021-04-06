package com.sihaloho.cleanarsitecture.domain.usecase


import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository

class MainInteractor(private val mainRepository: IMainRepository) : MainUseCase {
    override fun getListGame() = mainRepository.getListGame()

}