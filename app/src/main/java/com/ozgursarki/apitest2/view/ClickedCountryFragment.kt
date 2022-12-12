package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.ozgursarki.apitest2.databinding.ClickedCountryFragmentBinding
import com.ozgursarki.apitest2.viewmodel.ClickedCountryViewModel
import com.squareup.picasso.Picasso

class ClickedCountryFragment : Fragment() {

    private lateinit var viewmodel: ClickedCountryViewModel
    private lateinit var binding: ClickedCountryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ClickedCountryFragmentBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    val args: ClickedCountryFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryName = args.countryName

        viewmodel = ViewModelProvider(this)[ClickedCountryViewModel::class.java]

        viewmodel.getFlagsInfo(countryName)

        viewmodel.infoFlag.observe(viewLifecycleOwner){
            val xyz = it[0]
            Picasso.get().load(xyz.flags.png).into(binding.countryImage)

            binding.countryName.text = xyz.name.official
            binding.countryLang.text = xyz.languages.tur
            binding.countryRegion.text = xyz.region
            binding.countryCapital.text = xyz.capital[0]


        }

    }
}