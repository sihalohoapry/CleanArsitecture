package com.sihaloho.cleanarsitecture.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseGame(

	@field:SerializedName("results")
	val resultGames: List<ListGames>
)

data class ListGames(

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int,

	@field:SerializedName("released")
	val released: String,

	@field:SerializedName("background_image")
	val backgroundImage: String,

	@field:SerializedName("name")
	val name: String,
)


