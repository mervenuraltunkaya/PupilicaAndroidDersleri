package com.merve.listelemearayuzu.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.merve.listelemearayuzu.R
import com.merve.listelemearayuzu.data.Kategoriler
import com.merve.listelemearayuzu.databinding.KategoriCardTasarimBinding

class KategorilerAdpter (var mContext: Context, var kategorilerListesi:List<Kategoriler>) :
    RecyclerView.Adapter<KategorilerAdpter.KategoriCardTasarimTutucu>() {

    inner class KategoriCardTasarimTutucu (var kategoriTasarim: KategoriCardTasarimBinding):
        RecyclerView.ViewHolder(kategoriTasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriCardTasarimTutucu {
       var tasarimKategori= KategoriCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KategoriCardTasarimTutucu(tasarimKategori)
    }

    override fun onBindViewHolder(holder: KategoriCardTasarimTutucu, position: Int) {
        val kategori=kategorilerListesi.get(position)
        val tKategori=holder.kategoriTasarim
        tKategori.tVKategoriAdi.text="${kategori.kategori_adi}"
        tKategori.iVKategoriResim.setImageResource(
            mContext.resources.getIdentifier(kategori.kategori_resim,"drawable",mContext.packageName)
        )

    }

    override fun getItemCount(): Int {
        return kategorilerListesi.size
    }

}