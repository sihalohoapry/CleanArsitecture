package com.sihaloho.cleanarsitecture.data

import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import com.sihaloho.cleanarsitecture.domain.entity.Game
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MainRepository(private val remoteDataSource: RemoteDataSource) : IMainRepository {
    override fun getListGame(): Flow<List<Game>> {
        return remoteDataSource.getDataGame().map {
            DataMapper.responseToDomain(it)
        }
    }


}