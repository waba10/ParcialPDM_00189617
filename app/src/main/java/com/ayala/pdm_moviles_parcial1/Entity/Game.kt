package com.ayala.pdm_moviles_parcial1.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "game_table")
data class Game(
    @ColumnInfo(name = "local") val local:String= "N/A",
    @ColumnInfo(name = "visitante") val visitante: String = "N/a",
    @ColumnInfo(name = "total_local") val total_local: String = "N/a",
    @ColumnInfo(name = "total_visitante") val total_visitante: String = "N/a",
    @ColumnInfo(name = "fecha") val fecha:String= "N/A",
    @ColumnInfo(name = "hora") val hora: String = "N/a"


) {
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}