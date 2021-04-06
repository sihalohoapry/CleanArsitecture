package com.sihaloho.cleanarsitecture.domain.usecase

import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.domain.entity.Game
import kotlinx.coroutines.flow.Flow

interface MainUseCase {
    fun getListGame() : Flow<ResponseApi<List<Game>>>
}