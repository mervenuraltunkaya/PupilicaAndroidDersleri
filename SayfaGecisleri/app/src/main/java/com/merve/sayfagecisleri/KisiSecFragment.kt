package com.merve.sayfagecisleri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.sayfagecisleri.databinding.FragmentKisiSecBinding

class KisiSecFragment : Fragment() {
    private lateinit var binding: FragmentKisiSecBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentKisiSecBinding.inflate(inflater,container,false)

        binding.buttonDevamEt.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.grupSonucGecis)
            //it butonu temsil ediyo
        }

        return binding.root
    }

}