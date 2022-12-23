package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozgursarki.apitest2.databinding.ClickedCountryFragmentBinding
import com.ozgursarki.apitest2.viewmodel.ClickedCountryViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ClickedCountryFragment : Fragment() {

    private val viewmodel: ClickedCountryViewModel by viewModels()
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
        viewmodel.getDetails(countryName)


        viewmodel.infoFlag.observe(viewLifecycleOwner){
            val details = it[0]
            Picasso.get().load(details.flags.png).into(binding.countryImage)

            binding.countryName.text = details.name.official
            binding.countryLang.text = details.languages.tur
            binding.countryRegion.text = details.region
            binding.countryCapital.text = details.capital[0]


        }

    }
}