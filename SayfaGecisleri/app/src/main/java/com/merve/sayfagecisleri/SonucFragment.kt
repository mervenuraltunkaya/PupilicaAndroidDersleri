package com.merve.sayfagecisleri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.merve.sayfagecisleri.databinding.FragmentSonucBinding
import androidx.navigation.fragment.findNavController


class SonucFragment : Fragment() {
    private lateinit var binding: FragmentSonucBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSonucBinding.inflate(inflater,container,false)

        val backPress = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Callback devre dışı bırakılıyor (istersen)
                isEnabled = false

                // AnasayfaFragment'a yönlendirme
                findNavController().navigate(R.id.anasayfaDonus)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPress)


        return binding.root
    }

}