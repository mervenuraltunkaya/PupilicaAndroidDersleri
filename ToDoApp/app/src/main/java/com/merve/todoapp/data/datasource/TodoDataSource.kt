package com.merve.todoapp.data.datasource

import com.merve.todoapp.data.entity.Todo
import com.merve.todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var todoDao: TodoDao) {
    suspend fun kaydet(hedef_ad: String){
        val yeniHedef = Todo(0,hedef_ad)
        todoDao.kaydet(yeniHedef)
    }

    suspend fun guncelle(hedef_id:Int,hedef_ad: String){
        val guncellenenHedef = Todo(hedef_id,hedef_ad)
        todoDao.guncelle(guncellenenHedef)
    }

    suspend fun sil(hedef_id: Int){
        val silinenHedef = Todo(hedef_id,"")
        todoDao.sil(silinenHedef)
    }

    suspend fun hedefleriYukle() : List<Todo> = withContext(Dispatchers.IO) {
        return@withContext  todoDao.hedefleriYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Todo> = withContext(Dispatchers.IO) {
        return@withContext  todoDao.ara(aramaKelimesi)
    }
}
