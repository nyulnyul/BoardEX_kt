package com.example.board.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.board.domain.model.Posts
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {
    @Query("SELECT * FROM posts")
    fun getAll(): Flow<List<Posts>>
    @Insert
    fun insert(posts : Posts)
    @Delete
    fun delete(posts : Posts)
}