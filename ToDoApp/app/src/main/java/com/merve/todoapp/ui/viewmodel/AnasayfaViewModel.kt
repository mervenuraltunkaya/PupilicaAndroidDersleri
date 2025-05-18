package com.merve.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.todoapp.data.entity.Todo
import com.merve.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var todoRepository:TodoRepository) : ViewModel() {
    var todoListesi = MutableLiveData<List<Todo>>()

    init {
        hedefleriYukle()
    }

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.sil(kisi_id)
            hedefleriYukle()
        }
    }

    fun hedefleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.hedefleriYukle()//Tetikleme
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.ara(aramaKelimesi)//Tetikleme
        }
    }
}
