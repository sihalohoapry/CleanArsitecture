package com.sihaloho.cleanarsitecture.domain.repository

import com.sihaloho.cleanarsitecture.data.Resource
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.domain.entity.Game
import kotlinx.coroutines.flow.Flow

interface IMainRepository {
    fun getListGame() : Flow<ResponseApi<List<Game>>>
}