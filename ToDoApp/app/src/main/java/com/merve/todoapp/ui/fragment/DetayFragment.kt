package com.merve.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.merve.todoapp.R
import com.merve.todoapp.databinding.FragmentDetayBinding
import com.merve.todoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val bundle: DetayFragmentArgs by navArgs()
        val gelenHedef = bundle.hedef

        binding.editTextToDo.setText(gelenHedef.hedef_ad)

        binding.buttonGuncelle.setOnClickListener {
            val hedef_ad = binding.editTextToDo.text.toString()
            viewModel.guncelle(gelenHedef.hedef_id,hedef_ad)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}