package com.merve.todoapp.data.repo

import com.merve.todoapp.data.datasource.TodoDataSource
import com.merve.todoapp.data.entity.Todo

class TodoRepository(var TodoDataSource : TodoDataSource) {

    suspend fun kaydet(hedef_ad:String) {
        TodoDataSource.kaydet(hedef_ad)
    }

    suspend fun guncelle(hedef_id:Int,hedef_ad: String)
            = TodoDataSource.guncelle(hedef_id,hedef_ad)

    suspend fun sil(hedef_id: Int) = TodoDataSource.sil(hedef_id)

    suspend fun hedefleriYukle() : List<Todo> = TodoDataSource.hedefleriYukle()

    suspend fun ara(aramaKelimesi:String) : List<Todo> = TodoDataSource.ara(aramaKelimesi)
}
