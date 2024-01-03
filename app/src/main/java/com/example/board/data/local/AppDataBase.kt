package com.example.board.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.board.domain.model.Posts

@Database(entities = [Posts::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun postDAO(): PostDAO
    companion object{
        const val DB_NAME = "posts_db"
    }
}