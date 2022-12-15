package com.ozgursarki.apitest2.view


import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.adapter.CountryListAdapter
import com.ozgursarki.apitest2.databinding.CountryListFragmentBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewmodel.CountryListViewModel


class CountryListFragment : Fragment(), ClickListenerForFlag {

    private lateinit var viewmodel: CountryListViewModel
    private lateinit var binding: CountryListFragmentBinding
    private val multiRVAdapter = CountryListAdapter(countryList = ArrayList<Countries>())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CountryListFragmentBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CountryListFragment.context)
            adapter = multiRVAdapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = CountryListAdapter(arrayListOf())
        binding.recyclerview.adapter = adapter
        adapter.setListener(this)

        binding.searchview.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.searchChange(newText!!)
                return true
            }

        })

        viewmodel = ViewModelProvider(this)[CountryListViewModel::class.java]

        viewmodel.getCountryName()


        viewmodel.countries.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }



    override fun clicked(flag: Countries) {
        val action = CountryListFragmentDirections.actionCountryListFragmentToClickedCountryFragment(flag.name.common)
        this.findNavController().navigate(action)
    }

}