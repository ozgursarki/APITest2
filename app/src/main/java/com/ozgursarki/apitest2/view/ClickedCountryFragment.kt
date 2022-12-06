package com.ozgursarki.apitest2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ozgursarki.apitest2.adapter.ClickedCountryAdapter
import com.ozgursarki.apitest2.databinding.ClickedCountryFragmentBinding
import com.ozgursarki.apitest2.viewmodel.ClickedCountryViewModel

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

        val adapter = ClickedCountryAdapter(arrayListOf())

        viewmodel = ViewModelProvider(this)[ClickedCountryViewModel::class.java]

        viewmodel.getFlagsInfo("turkey")

        viewmodel.infoFlag.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }
}