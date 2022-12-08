package com.ozgursarki.apitest2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.adapter.CountryListAdapter
import com.ozgursarki.apitest2.databinding.CountryListFragmentBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewmodel.CountryListViewModel
import java.util.*
import kotlin.collections.ArrayList

class CountryListFragment(val country: ArrayList<Countries>) : Fragment(),
    ClickListenerForFlag {

    private lateinit var viewmodel: CountryListViewModel
    private lateinit var binding: CountryListFragmentBinding
    val displayList = ArrayList<Countries>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CountryListFragmentBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = CountryListAdapter(arrayListOf())
        binding.recyclerview.adapter = adapter
        adapter.setListener(this)


        //val myAdapter = CountryListAdapter(displayList)

        viewmodel = ViewModelProvider(this)[CountryListViewModel::class.java]


        viewmodel.getAllCountries()

        //displayList.addAll(countryList)
        viewmodel.countries.observe(viewLifecycleOwner) {

            adapter.setList(it)
        }
    }



    override fun clicked(flag: Countries) {
        findNavController().navigate(R.id.action_countryListFragment_to_clickedCountryFragment)
    }


    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        val menuItem = menu.findItem(R.id.menu_search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {

                        displayList.clear()
                        val search = newText.lowercase(Locale.getDefault())
                        country.forEach {
                            if (it.name.official.lowercase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        binding.recyclerview.adapter!!.notifyDataSetChanged()
                    } else {
                        displayList.clear()
                        displayList.addAll(country)
                        binding.recyclerview.adapter!!.notifyDataSetChanged()

                    }
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }



}