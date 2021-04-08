package com.sihaloho.cleanarsitecture.data

import com.sihaloho.cleanarsitecture.data.source.local.LocalDataSource
import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import com.sihaloho.cleanarsitecture.domain.entity.Game
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MainRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : IMainRepository {

    override fun getListGame(): Flow<Resource<List<Game>>> =

        object : NetworkBoundResource<List<Game>, List<ListGames>>(){
            override fun loadDb(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.entitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = true

            override suspend fun createCall(): Flow<ResponseApi<List<ListGames>>> = remoteDataSource.getDataGame()


            override suspend fun saveCallResult(data: List<ListGames>) {
                val gameList = DataMapper.responseToEntities(data)
                localDataSource.insertGame(gameList)
            }

        }.asFlow()

}