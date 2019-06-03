package com.ayala.pdm_moviles_parcial1.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ayala.pdm_moviles_parcial1.Dao.GameDao
import com.ayala.pdm_moviles_parcial1.Entity.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameRoomDatabase: RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: GameRoomDatabase?=null

        fun getDatabase(context: Context, scope: CoroutineScope): GameRoomDatabase {

            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    GameRoomDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabseCall(scope))
                    .build()
                INSTANCE= instance
                instance
            }

        }
    }

    private class DatabseCall(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { appDatabase ->
                scope.launch(Dispatchers.IO) {
                    LlenarDB(appDatabase.gameDao())
                }
            }
        }


        suspend fun LlenarDB(gameDAO: GameDao) {

           /* var game= Game("Real Madrid", "Barcelona", "1", "2", "3"
            ,"4" , "5", "6", "02/06/19", "9:56")

            gameDAO.insert(game)

            game= Game("Real Madrid1", "Barcelona1", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)

            game= Game("Real Madrid2", "Barcelona2", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid3", "Barcelona3", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid4", "Barcelona4", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid5", "Barcelona5", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid6", "Barcelona6", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid7", "Barcelona7", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid8", "Barcelona8", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)
            game= Game("Real Madrid9", "Barcelona9", "1", "2", "3"
                ,"4" , "5", "6", "02/06/19", "9:56")


            gameDAO.insert(game)*/

        }
    }
}