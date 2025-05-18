package com.merve.todoapp.di

import android.content.Context
import androidx.room.Room
import com.merve.todoapp.data.datasource.TodoDataSource
import com.merve.todoapp.data.repo.TodoRepository
import com.merve.todoapp.room.TodoDao
import com.merve.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodoRepository(todoDataSource: TodoDataSource) : TodoRepository{
        return TodoRepository(todoDataSource)
    }

    @Provides
    @Singleton
    fun provideTodoDataSource(todoDao: TodoDao) : TodoDataSource {
        return TodoDataSource(todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"toDos.sqlite")
            .createFromAsset("toDos.sqlite")
            .build()
        return veritabani.getTodoDao()
    }
}

