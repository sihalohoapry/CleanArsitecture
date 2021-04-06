package com.sihaloho.cleanarsitecture.data

import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import com.sihaloho.cleanarsitecture.domain.entity.Game
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map


class MainRepository(val remoteDataSource: RemoteDataSource) : IMainRepository {

    override fun getListGame(): Flow<ResponseApi<List<Game>>> {
        return 
    }

}