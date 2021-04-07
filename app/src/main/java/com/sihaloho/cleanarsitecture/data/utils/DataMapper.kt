package com.sihaloho.cleanarsitecture.data.utils

import com.sihaloho.cleanarsitecture.data.source.local.entity.GameEntity
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
    fun responseToEntities(input: List<ListGames>) : List<GameEntity>{
        val listGames = ArrayList<GameEntity>()
        input.map {
            val game =GameEntity(
                id = it.id,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                released = it.released,
                backgroundImage = it.backgroundImage,
                name = it.name,
            )
            listGames.add(game)
        }
        return listGames
    }

    fun entitiesToDomain(input: List<GameEntity>) : List<Game> =
    input.map {
        Game(
            id = it.id,
            rating = it.rating,
            ratingsCount = it.ratingsCount,
            released = it.released,
            backgroundImage = it.backgroundImage,
            name = it.name
        )
    }




}