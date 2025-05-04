package com.merve.sayfagecisleri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.merve.sayfagecisleri.databinding.FragmentBireyselEtkinlikDetayBinding
import java.text.SimpleDateFormat
import java.util.Locale

class BireyselEtkinlikDetayFragment : Fragment() {
    private lateinit var binding: FragmentBireyselEtkinlikDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBireyselEtkinlikDetayBinding.inflate(inflater,container,false)

        val etkinlikler = listOf(
            getString(R.string.etkinlik_meditasyon),
            getString(R.string.etkinlik_yoga),
            getString(R.string.etkinlik_doga_yuruyusu),
            getString(R.string.etkinlik_sinema),
            getString(R.string.etkinlik_tiyatro)
        )

        val arrayAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,etkinlikler)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        val constraintsBuilder = CalendarConstraints.Builder()
            .setValidator(DateValidatorPointForward.now())

        binding.buttonTarihSec.setOnClickListener {
            val dp= MaterialDatePicker.Builder.datePicker()
                .setTitleText("Tarih Seç")
                .setCalendarConstraints(constraintsBuilder.build()) // Geçmiş tarihler devre dışı
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds()) // Başlangıç olarak bugünü seç
                .build()
            dp.show(parentFragmentManager,"Tarih")

            dp.addOnPositiveButtonClickListener {
                val df= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val tarih=df.format(it)
                binding.editTextDate.setText(tarih)
            }
        }

        binding.buttonSaatSec.setOnClickListener {
            val tp= MaterialTimePicker.Builder()
                .setTitleText("Saat Seç")
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()
            tp.show(parentFragmentManager,"Saat")

            tp.addOnPositiveButtonClickListener{
                binding.editTextTime.setText("${tp.hour} : ${tp.minute}")
            }
        }

        binding.buttonIlerleBireysel.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.bireyselSonucGecis)
            //it butonu temsil ediyo
        }

        return binding.root
    }

}