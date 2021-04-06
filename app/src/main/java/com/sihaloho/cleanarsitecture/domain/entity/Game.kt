package com.sihaloho.cleanarsitecture.domain.entity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val rating: Double,
    val id: Int,
    val ratingsCount: Int,
    val released: String,
    val backgroundImage: String,
    val name: String
) : Parcelable