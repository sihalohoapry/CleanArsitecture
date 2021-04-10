package com.sihaloho.cleanarsitecture.data.source.remote.response

sealed class ResponseApi <out R> {
    data class Success<out T>(val data: T): ResponseApi<T>()
    data class Error(val errorMessage : String): ResponseApi<Nothing>()
    object Empty: ResponseApi<Nothing>()
}