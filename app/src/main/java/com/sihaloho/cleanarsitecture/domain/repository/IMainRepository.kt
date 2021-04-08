package com.sihaloho.cleanarsitecture.domain.repository

import com.sihaloho.cleanarsitecture.domain.entity.Game
import kotlinx.coroutines.flow.Flow

interface IMainRepository {
    fun getListGame() : Flow<List<Game>>
}