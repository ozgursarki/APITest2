package com.ozgursarki.apitest2.view


import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.adapter.CountryListAdapter
import com.ozgursarki.apitest2.databinding.CountryListFragmentBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewmodel.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryListFragment : Fragment(), ClickListenerForFlag {

    private lateinit var binding: CountryListFragmentBinding
    private val viewmodel: CountryListViewModel by viewModels()

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

        binding.searchview.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.searchChange(newText!!)
                return true
            }

        })

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