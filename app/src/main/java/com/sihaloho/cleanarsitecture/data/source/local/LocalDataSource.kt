package com.sihaloho.cleanarsitecture.data.source.local

import com.sihaloho.cleanarsitecture.data.source.local.entity.GameEntity
import com.sihaloho.cleanarsitecture.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameDao: GameDao) {

    fun getAllGame() : Flow<List<GameEntity>> = gameDao.getAllGame()
    suspend fun insertGame(gameList: List<GameEntity>) = gameDao.insertGame(gameList)

}