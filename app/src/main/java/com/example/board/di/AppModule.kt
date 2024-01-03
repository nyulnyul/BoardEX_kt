package com.example.board.di

import android.app.Application
import androidx.room.Room
import com.example.board.data.local.AppDataBase
import com.example.board.data.repository.PostRepositoryImpl
import com.example.board.domain.repository.PostRepository
import com.example.board.domain.usecase.AddPosts
import com.example.board.domain.usecase.DeletePosts
import com.example.board.domain.usecase.GetPosts
import com.example.board.domain.usecase.PostUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app : Application): AppDataBase {
        return Room.databaseBuilder(app, AppDataBase::class.java, AppDataBase.DB_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(db : AppDataBase) : PostRepository {
        return PostRepositoryImpl(db.postDAO())
    }

    @Provides
    @Singleton
    fun provideUseCase(repository : PostRepository) : PostUseCases {
        return PostUseCases(getPosts = GetPosts(repository), deletePosts = DeletePosts(repository), addPosts = AddPosts(repository))
    }
}