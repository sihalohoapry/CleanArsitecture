package com.sihaloho.cleanarsitecture.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.utils.DataMapper
import com.sihaloho.cleanarsitecture.domain.entity.Game
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MainRepository(private val remoteDataSource: RemoteDataSource) : IMainRepository {

    private var _isLoading = MutableLiveData<Boolean>()
    private val isLoading : LiveData<Boolean> get() = _isLoading

    override fun getListGame(): Flow<List<Game>> {
        _isLoading.value = true
        return remoteDataSource.getDataGame().map {
            _isLoading.value = false
            DataMapper.responseToDomain(it)
        }
    }


}