package com.sihaloho.cleanarsitecture.data.source.remote

import com.sihaloho.cleanarsitecture.data.Resource
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ResponseApi.Success -> {
                if (apiResponse.data != null) {
                    emit(Resource.Success(loadData(apiResponse.data)))
                }
            }
            is ResponseApi.Error -> {
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
        }
    }

    protected abstract suspend fun createCall(): Flow<ResponseApi<RequestType>>

    protected abstract suspend fun loadData(data: RequestType): ResultType

    fun asFlow(): Flow<Resource<ResultType>> = result
}