package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ozgursarki.ClickListener
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.adapter.CountryListAdapter
import com.ozgursarki.apitest2.databinding.CountryListFragmentBinding
import com.ozgursarki.apitest2.model.CountryNameItem
import com.ozgursarki.apitest2.viewmodel.CountryListViewModel

class CountryListFragment : Fragment(), ClickListener{

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

        viewmodel = ViewModelProvider(this)[CountryListViewModel::class.java]

        viewmodel.currentName.observe(viewLifecycleOwner){
            adapter.setList(it)

            getCountry()
            getCountryLang()
        }
    }

    fun getCountry(){
        viewmodel.getCountryName()
    }

    fun getCountryLang(){
        viewmodel.getCountryLang()
    }

    override fun clicked(country: CountryNameItem) {
        this.findNavController().navigate(R.id.action_countryListFragment_to_clickedCountryFragment)
    }


}