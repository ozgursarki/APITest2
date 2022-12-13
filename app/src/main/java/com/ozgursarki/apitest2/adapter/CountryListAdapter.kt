package com.ozgursarki.apitest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewholder.CountryViewHolder

class CountryListAdapter(private var countryList: ArrayList<Countries>): RecyclerView.Adapter<CountryViewHolder>() {

    private lateinit var clicklistener:ClickListenerForFlag
    private   var searchList : ArrayList<Countries> = arrayListOf()

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

    fun setList(newList: ArrayList<Countries>){
        countryList = newList
        searchList.addAll(newList)
        notifyDataSetChanged()
    }

    fun searchChange(text : String){
        val searchQuery = searchList.filter {
            it.name.official.startsWith(text,true)

        }

        countryList.clear()
        searchQuery.forEach {
            countryList.add(it)
        }
        notifyDataSetChanged()

    }



    fun setListener(clickListenerForFlag: ClickListenerForFlag){
        clicklistener = clickListenerForFlag
    }

}