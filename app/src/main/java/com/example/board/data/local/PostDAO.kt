package com.example.board.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.board.domain.model.Posts
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {
    @Query("SELECT * FROM posts")
    fun getAll(): Flow<List<Posts>>
    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getPostById(id: Int): Posts?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts : Posts)
    @Delete
    suspend fun delete(posts : Posts)
}