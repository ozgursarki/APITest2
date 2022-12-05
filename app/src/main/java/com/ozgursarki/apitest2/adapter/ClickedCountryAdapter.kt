package com.ozgursarki.apitest2.adapter

import android.animation.LayoutTransition
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.viewholder.ClickedCountryViewHolder

class ClickedCountryAdapter: RecyclerView.Adapter<ClickedCountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClickedCountryViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clicked_country_row,parent,false)
        return ClickedCountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClickedCountryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}