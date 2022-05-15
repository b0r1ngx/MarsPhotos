package com.example.android.marsphotos.room

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

const val DB_NAME = "mars"

@Entity(tableName = DB_NAME)
data class Mars (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "imgUrl") val imgUrl: String
)

interface MarsDao {
    @Query("SELECT * FROM $DB_NAME")
    fun getAll(): List<Mars>

    @Query("SELECT imgUrl FROM $DB_NAME")
    fun getAllImgUrls(): List<String>
}

@Database(entities = [Mars::class], version = 1)
abstract class MarsDatabase : RoomDatabase() {
    abstract fun marsDao(): MarsDao
}