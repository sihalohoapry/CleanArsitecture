package com.sihaloho.cleanarsitecture.data


import com.sihaloho.cleanarsitecture.data.source.remote.NetworkBoundResource
import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import com.sihaloho.cleanarsitecture.domain.entity.Game
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow


class MainRepository(private val remoteDataSource: RemoteDataSource) : IMainRepository {


    override fun getListGame(): Flow<Resource<List<Game>>> =
            object : NetworkBoundResource<List<Game>, List<ListGames>>(){
                override suspend fun createCall(): Flow<ResponseApi<List<ListGames>>> {
                    return remoteDataSource.getDataGame()
                }

                override suspend fun loadData(data: List<ListGames>): List<Game> {
                    return DataMapper.responseToDomain(data)
                }

            }.asFlow()


}