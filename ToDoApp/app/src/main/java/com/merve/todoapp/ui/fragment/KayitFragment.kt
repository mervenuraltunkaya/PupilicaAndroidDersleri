package com.merve.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.merve.todoapp.R
import com.merve.todoapp.databinding.FragmentKayitBinding
import com.merve.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val hedef_ad = binding.editTextToDo.text.toString()
            viewModel.kaydet(hedef_ad)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}