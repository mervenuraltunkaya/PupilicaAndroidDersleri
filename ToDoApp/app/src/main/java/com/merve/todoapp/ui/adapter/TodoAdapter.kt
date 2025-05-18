package com.merve.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.merve.todoapp.data.entity.Todo
import com.merve.todoapp.databinding.CardTasarimBinding
import com.merve.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.merve.todoapp.ui.viewmodel.AnasayfaViewModel
import com.merve.todoapp.utils.gecisYap

class TodoAdapter(var mContext: Context,
                  var todoListesi: List<Todo>,
                  var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val hedef = todoListesi.get(position)//0,1,2
        val t = holder.tasarim
        t.textViewToDo.text = hedef.hedef_ad

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(hedef = hedef )
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${hedef.hedef_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.sil(hedef.hedef_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoListesi.size
    }
}