package com.sihaloho.cleanarsitecture.data.source.remote

import android.util.Log
import com.sihaloho.cleanarsitecture.data.source.remote.network.ApiService
import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {

    fun getDataGame(): Flow<List<ListGames>> =
         flow {
            try {

                val response = apiService.getListGame().resultGames
                emit(response)

            }catch (e : Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

}