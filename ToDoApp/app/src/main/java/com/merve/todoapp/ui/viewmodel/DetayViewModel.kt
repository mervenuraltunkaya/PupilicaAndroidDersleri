package com.merve.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.merve.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var todoRepository:TodoRepository) : ViewModel() {

    fun guncelle(hedef_id:Int,hedef_ad: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.guncelle(hedef_id,hedef_ad)
        }
    }
}