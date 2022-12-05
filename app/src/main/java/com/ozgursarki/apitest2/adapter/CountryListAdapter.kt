package com.ozgursarki.apitest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.ClickListener
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.CountryNameItem
import com.ozgursarki.apitest2.viewholder.CountryViewHolder

class CountryListAdapter(private var countryList: ArrayList<CountryNameItem>): RecyclerView.Adapter<CountryViewHolder>() {

    private lateinit var clicklistener:ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_row,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.setData(countryList[position]){
           clicklistener.clicked(it)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun setList(newList: ArrayList<CountryNameItem>){
        countryList = newList
        notifyDataSetChanged()
    }
}