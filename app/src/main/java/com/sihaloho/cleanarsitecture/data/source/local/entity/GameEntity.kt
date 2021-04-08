package com.sihaloho.cleanarsitecture.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "ratingsCount")
    var ratingsCount: Int,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "backgroundImage")
    var backgroundImage: String,

    @ColumnInfo(name = "name")
    var name: String
) : Parcelable