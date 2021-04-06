package com.sihaloho.cleanarsitecture.presentation.di


import com.sihaloho.cleanarsitecture.BuildConfig
import com.sihaloho.cleanarsitecture.data.MainRepository
import com.sihaloho.cleanarsitecture.data.source.remote.RemoteDataSource
import com.sihaloho.cleanarsitecture.data.source.remote.network.ApiService
import com.sihaloho.cleanarsitecture.domain.repository.IMainRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
    }

    single {
        val retrofit = Retrofit.Builder()
                .baseUrl("${BuildConfig.BASE_URL}/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()

        retrofit.create(ApiService::class.java)
    }
}
val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IMainRepository> { MainRepository(get()) }
}