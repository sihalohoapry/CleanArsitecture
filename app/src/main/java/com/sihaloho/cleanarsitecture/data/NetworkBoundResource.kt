package com.sihaloho.cleanarsitecture.data

import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseApi
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType,RequestType> {

    private var result : Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadDb().first()
        if (shouldFetch(dbSource)){
            emit(Resource.Loading())
            when(val responseApi = createCall().first()){
                is ResponseApi.Success ->{
                    saveCallResult(responseApi.data)
                    emitAll(loadDb().map { Resource.Success(it) })
                }
                is ResponseApi.Empty ->{
                    emitAll(loadDb().map { Resource.Success(it) })
                }
                is ResponseApi.Error ->{
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(responseApi.errorMessage))
                }
            }


        }else{
            emitAll(loadDb().map { Resource.Success(it) })
        }
    }

    protected open fun onFetchFailed(){}
    protected abstract fun loadDb() : Flow<ResultType>
    protected abstract fun shouldFetch(data: ResultType?) : Boolean
    protected abstract suspend fun createCall() : Flow<ResponseApi<RequestType>>
    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result

}