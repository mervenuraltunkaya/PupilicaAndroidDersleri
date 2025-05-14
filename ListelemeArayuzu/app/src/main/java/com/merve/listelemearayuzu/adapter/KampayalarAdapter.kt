package com.merve.listelemearayuzu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merve.listelemearayuzu.data.Kampanyalar
import com.merve.listelemearayuzu.databinding.FragmentAnasayfaBinding
import com.merve.listelemearayuzu.databinding.KampanyaCardTasarimBinding

class KampayalarAdapter (var mContext: Context, var kampanyalarListesi: List<Kampanyalar>):
    RecyclerView.Adapter<KampayalarAdapter.KampanyaCardTasarimTutucu>(){

    inner class KampanyaCardTasarimTutucu(var tasarimKampanya:KampanyaCardTasarimBinding): RecyclerView.ViewHolder(tasarimKampanya.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KampanyaCardTasarimTutucu {
        val tasarimKampanya= KampanyaCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KampanyaCardTasarimTutucu(tasarimKampanya)
    }

    override fun onBindViewHolder(holder: KampanyaCardTasarimTutucu, position: Int) {
        val kampanya= kampanyalarListesi.get(position)
        val tKampanya=holder.tasarimKampanya

        tKampanya.imageView.setImageResource(mContext.resources.getIdentifier(kampanya.resim, "drawable",mContext.packageName))
    }

    override fun getItemCount(): Int {
        return kampanyalarListesi.size
    }
}