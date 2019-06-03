package com.ayala.pdm_moviles_parcial1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayala.pdm_moviles_parcial1.Entity.Game
import com.ayala.pdm_moviles_parcial1.Repository.GameRepository
import com.ayala.pdm_moviles_parcial1.Room.GameRoomDatabase
import kotlinx.coroutines.launch

class GameViewModel(application: Application): AndroidViewModel(application) {

    private val repository: GameRepository

    val allGames: LiveData<List<Game>>

    init{
        val GamesDao = GameRoomDatabase.getDatabase(application, viewModelScope).gameDao()
        repository= GameRepository(GamesDao)
        allGames=repository.allBooks
    }

    fun insert(game: Game)= viewModelScope.launch{
        repository.insert(game)

    }
    fun getAll(): LiveData<List<Game>> = repository.getAll()
}