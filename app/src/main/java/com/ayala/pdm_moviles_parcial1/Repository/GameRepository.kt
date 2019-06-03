package com.ayala.pdm_moviles_parcial1.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.ayala.pdm_moviles_parcial1.Dao.GameDao
import com.ayala.pdm_moviles_parcial1.Entity.Game

class GameRepository(private val libroDao: GameDao) {
    val allBooks: LiveData<List<Game>> = libroDao.getGames()

    @WorkerThread
    suspend fun insert(game: Game){
        libroDao.insert(game)
    }


    fun getAll(): LiveData<List<Game>> = libroDao.getGames()

}