package com.merve.sayfagecisleri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.navigation.Navigation
import com.merve.sayfagecisleri.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAnaSayfaBinding.inflate(inflater, container, false)

        binding.buttonGrup.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.grupDetayGecis)
            //it butonu temsil ediyo
        }

        binding.buttonBireysel.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.bireyselDetayGecis)
        }


        return binding.root
    }

}