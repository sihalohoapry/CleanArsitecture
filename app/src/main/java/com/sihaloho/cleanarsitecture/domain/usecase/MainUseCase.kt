package com.sihaloho.cleanarsitecture.domain.usecase

import com.sihaloho.cleanarsitecture.domain.entity.Game
import kotlinx.coroutines.flow.Flow

interface MainUseCase {
    fun getListGame() : Flow<List<Game>>
}