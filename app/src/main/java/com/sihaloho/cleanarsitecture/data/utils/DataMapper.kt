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
//    fun responseToEntities(input: List<ListGames>) : List<ListGameEntity>{
//        val listGames = ArrayList<ListGameEntity>()
//        input.map {
//            val game =ListGameEntity(
//                gameListId =it.id.toString(),
//                rating = it.rating,
//                ratingsCount = it.ratingsCount,
//                released = it.released,
//                backgroundImage = it.backgroundImage,
//                name = it.name,
//                isFavorite = false
//            )
//            listGames.add(game)
//        }
//        return listGames
//    }
//
//    fun entitiesToDomain(input: List<ListGameEntity>) : List<Game> =
//    input.map {
//        Game(
//            rating = it.rating,
//            id = it.gameListId.toInt(),
//            ratingsCount = it.ratingsCount,
//            released = it.released,
//            backgroundImage = it.backgroundImage,
//            name = it.name
//        )
//    }
//
//    fun domainToEntities(input: Game) = ListGameEntity(
//        gameListId =input.id.toString(),
//        rating = input.rating,
//        ratingsCount = input.ratingsCount,
//        released = input.released,
//        backgroundImage = input.backgroundImage,
//        name = input.name,
//        isFavorite = false
//    )


}