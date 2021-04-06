package com.sihaloho.cleanarsitecture.data.source.remote

import android.util.Log
import com.sihaloho.cleanarsitecture.data.source.remote.network.ApiService
import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {

    fun getDataGame(): Flow<ResponseApi<List<ListGames>>>{
        return flow {
            try {
                val response = apiService.getListGame()
                val dataArray = response.resultGames
                if (dataArray.isNotEmpty()){
                    emit(ResponseApi.Success(dataArray))
                }else{
                    emit(ResponseApi.Empty)
                }
            }catch (e : Exception){
                emit(ResponseApi.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}