package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.databinding.ClickedCountryFragmentBinding
import com.ozgursarki.apitest2.model.ClickedFlag
import com.ozgursarki.apitest2.model.Country
import com.ozgursarki.apitest2.model.InfoClickedFlag
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(this)[ClickedCountryViewModel::class.java]

        viewmodel.getFlagsInfo("peru")


        viewmodel.infoFlag.observe(viewLifecycleOwner){

            val xyz = it[0]
            Picasso.get().load(xyz.flags.png).into(binding.countryImage)

            binding.countryName.text = xyz.name.official
            binding.countryCurrency.text = xyz.currencies.toString()
            binding.countryLang.text = xyz.languages.tur
            binding.countryRegion.text = xyz.region
        }
        }
    }


        /*
         val countryName = binding.countryName
                val countryImage = binding.countryImage
                val countryRegion = binding.countryRegion
                val countryLang = binding.countryLang
                val countryCurrency = binding.countryCurrency



                Picasso.get().load("https://restcountries.com/v3.1/all/flags").into(countryImage)

                  countryName.text = binding.countryName.text
                countryRegion.text = flag.region
                countryLang.text = flag.languages.tur
                countryCurrency.text = flag.currencies.TRY.toString()
         */