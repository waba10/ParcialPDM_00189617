package com.ayala.pdm_moviles_parcial1.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ayala.pdm_moviles_parcial1.Entity.Game


@Dao
interface GameDao {
    @Query("SELECT * FROM game_table")
    fun getGames(): LiveData<List<Game>>

    @Insert
    suspend fun insert(game: Game)

    @Query("SELECT * FROM game_table WHERE local LIKE:equipo")
    fun searchTitle(equipo:String): LiveData<List<Game>>
}