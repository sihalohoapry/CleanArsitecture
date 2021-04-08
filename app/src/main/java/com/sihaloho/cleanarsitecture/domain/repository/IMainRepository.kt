package com.sihaloho.cleanarsitecture.domain.repository

import com.sihaloho.cleanarsitecture.data.Resource
import com.sihaloho.cleanarsitecture.domain.entity.Game
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IMainRepository {
    fun getListGame() : Flow<List<Game>>
}