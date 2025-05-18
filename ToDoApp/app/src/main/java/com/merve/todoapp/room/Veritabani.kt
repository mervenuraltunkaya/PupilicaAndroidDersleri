package com.merve.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.merve.todoapp.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class Veritabani: RoomDatabase() {
    abstract fun getTodoDao(): TodoDao
}