package com.sihaloho.cleanarsitecture.data.utils

import com.sihaloho.cleanarsitecture.data.source.remote.response.ListGames
import com.sihaloho.cleanarsitecture.domain.entity.Game

object DataMapper {

    fun responseToDomain(input: List<ListGames>): List<Game> {
        val listGames = ArrayList<Game>()
        input.map {
            val game = Game(
                    rating = it.rating,
                    id = it.id,
                    ratingsCount = it.ratingsCount,
                    released = it.released,
                    backgroundImage = it.backgroundImage,
                    name = it.name
            )
            listGames.add(game)
        }
        return listGames
    }


}