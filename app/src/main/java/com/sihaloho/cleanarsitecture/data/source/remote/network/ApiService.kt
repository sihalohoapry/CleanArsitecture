package com.sihaloho.cleanarsitecture.data.source.remote.network

import com.sihaloho.cleanarsitecture.BuildConfig
import com.sihaloho.cleanarsitecture.data.source.remote.response.ResponseGame
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("games?key="+ BuildConfig.API_KEY)
    suspend fun getListGame() : ResponseGame

}