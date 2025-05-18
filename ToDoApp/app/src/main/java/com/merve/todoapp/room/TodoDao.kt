package com.merve.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.merve.todoapp.data.entity.Todo

@Dao
interface TodoDao { //Dao : Database Access Object
    @Query("SELECT * FROM toDos")
    suspend fun hedefleriYukle() : List<Todo>

    @Insert
    suspend fun kaydet(hedef: Todo)

    @Update
    suspend fun guncelle(hedef: Todo)

    @Delete
    suspend fun sil(hedef: Todo)

    @Query("SELECT * FROM toDos WHERE hedef_name LIKE '%' || :aramaKelimesi ||'%'") // alttsn yukarıya parametre slındı || şunlarla
    suspend fun ara(aramaKelimesi:String): List<Todo>
}