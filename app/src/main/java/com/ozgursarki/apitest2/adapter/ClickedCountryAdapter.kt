package com.ozgursarki.apitest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.ClickedFlag
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewholder.ClickedCountryViewHolder

class ClickedCountryAdapter(private var flag: ArrayList<ClickedFlag>) : RecyclerView.Adapter<ClickedCountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClickedCountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clicked_country_fragment,parent,false)
        return ClickedCountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClickedCountryViewHolder, position: Int) {
        holder.getFlagInfo(flag[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setList(newInfo: ArrayList<ClickedFlag>){
        flag = newInfo
        notifyDataSetChanged()
    }
}