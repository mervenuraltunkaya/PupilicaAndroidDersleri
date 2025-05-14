package com.merve.listelemearayuzu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.merve.listelemearayuzu.adapter.KampayalarAdapter
import com.merve.listelemearayuzu.adapter.KategorilerAdpter
import com.merve.listelemearayuzu.data.Kampanyalar
import com.merve.listelemearayuzu.data.Kategoriler
import com.merve.listelemearayuzu.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean { //arama ikonuna basıldığında sonuç getiriyor
                ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe,sildikçe sonuç etiren fonksiyon
                ara(newText)
                return true
            }

        })

        val kampanyalarListesi= ArrayList<Kampanyalar>()
        val kamp1=Kampanyalar("kampanya1")
        val kamp2=Kampanyalar("kampanya2")
        kampanyalarListesi.add(kamp1)
        kampanyalarListesi.add(kamp2)


        binding.rWKampanyalar.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val adapter= KampayalarAdapter(requireContext(),kampanyalarListesi)
        binding.rWKampanyalar.adapter=adapter


        val kategoriListesi = ArrayList<Kategoriler>()
        val k1=Kategoriler("İndirimler", "indirimler")
        val k2=Kategoriler("Meyve & Sebze", "meyvesebze")
        val k3=Kategoriler("Et & Tavuk & Şarküteri", "sarkuteri")
        val k4=Kategoriler("Fırsat Ürünleri", "firsatlar")
        val k5=Kategoriler("Atıştırmalık", "atistirmalik")
        val k6=Kategoriler("Su & İçecek", "icecekler")
        val k7=Kategoriler("Süt & Kahvaltılık", "sutyumurta")
        val k8=Kategoriler("Fırından", "firindan")
        val k9=Kategoriler("Everyday Roastery", "everydayroastery")
        val k10=Kategoriler("Temel Gıda", "temelgida")
        val k11=Kategoriler("Dondurma", "dondurma")
        val k12=Kategoriler("Ev Bakım", "evbakim")
        val k13=Kategoriler("Kişisel Bakım & Kozmetik", "kozmetik")
        val k14=Kategoriler("Dondurulmuş Gıda", "dondurulmusgida")
        val k15=Kategoriler("Hızlı Yemek", "hizliyemek")
        val k16=Kategoriler("Sağlıklı Yaşam", "saglikliyasam")
        val k17=Kategoriler("Pet Shop", "evcilhayvan")
        val k18=Kategoriler("Bebek", "bebek")
        val k19=Kategoriler("Ev & Yaşam", "evyasam_teknoloji")
        val k20=Kategoriler("Cinsel Sağlık", "cinselsaglik")

        kategoriListesi.add(k1)
        kategoriListesi.add(k2)
        kategoriListesi.add(k3)
        kategoriListesi.add(k4)
        kategoriListesi.add(k5)
        kategoriListesi.add(k6)
        kategoriListesi.add(k7)
        kategoriListesi.add(k8)
        kategoriListesi.add(k9)
        kategoriListesi.add(k10)
        kategoriListesi.add(k11)
        kategoriListesi.add(k12)
        kategoriListesi.add(k13)
        kategoriListesi.add(k14)
        kategoriListesi.add(k15)
        kategoriListesi.add(k16)
        kategoriListesi.add(k17)
        kategoriListesi.add(k18)
        kategoriListesi.add(k19)
        kategoriListesi.add(k20)


        val adapterKategoriler= KategorilerAdpter(requireContext(),kategoriListesi)
        binding.rWKategoriler.adapter=adapterKategoriler

        val layoutManager = GridLayoutManager(requireContext(), 12)
        binding.rWKategoriler.layoutManager = layoutManager

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position <= 2) 4 else 3
                // 12 / 4 = 3 → ilk 3 öğe 3’lü görünür
                // 12 / 3 = 4 → diğerleri 4’lü görünür
            }
        }

        return binding.root
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }

}