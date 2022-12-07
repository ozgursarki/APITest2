package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.adapter.CountryListAdapter
import com.ozgursarki.apitest2.databinding.CountryListFragmentBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.Country
import com.ozgursarki.apitest2.model.CountryNameItem
import com.ozgursarki.apitest2.viewmodel.CountryListViewModel

class CountryListFragment : Fragment(), ClickListenerForFlag {

    private lateinit var viewmodel: CountryListViewModel
    private lateinit var binding: CountryListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CountryListFragmentBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = CountryListAdapter(arrayListOf())
        binding.recyclerview.adapter = adapter
        adapter.setListener(this)

        viewmodel = ViewModelProvider(this)[CountryListViewModel::class.java]
        viewmodel.getAllCountries()
        viewmodel.countries.observe(viewLifecycleOwner){


            adapter.setList(it)

        }
    }

    fun getCountry(){
        viewmodel.getCountryName()
    }

    fun getCountryLang(){
        viewmodel.getCountryLang()
    }

    override fun clicked(country: Countries) {
        findNavController().navigate(R.id.action_countryListFragment_to_clickedCountryFragment)
    }


}