package com.ozgursarki.apitest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.databinding.CountryRowImageBinding
import com.ozgursarki.apitest2.databinding.CountryRowTextBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.viewholder.CountryViewHolder
import java.lang.IllegalArgumentException

class CountryListAdapter(private var countryList: ArrayList<Countries>): RecyclerView.Adapter<CountryViewHolder>() {

    private lateinit var clicklistener:ClickListenerForFlag
    private   var searchList : ArrayList<Countries> = arrayListOf()


    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return when(viewType){
            R.layout.country_row_text -> CountryViewHolder.TextViewHolder(
                CountryRowTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.country_row_image -> CountryViewHolder.ImageViewHolder(
                CountryRowImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("asdsfgsf")
        }
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        when(holder){
            is CountryViewHolder.ImageViewHolder -> holder.bind(countryList[position] as Countries.Flags)
            is CountryViewHolder.TextViewHolder -> holder.bind(countryList[position] as Countries.CountryName)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(countryList[position]){
            is Countries.CountryName -> R.layout.country_row_text
            is Countries.Flags -> R.layout.country_row_image
        }

    fun setList(newList: ArrayList<Countries>){
        countryList = newList
        searchList.addAll(newList)
        notifyDataSetChanged()
    }

    /*
    fun searchChange(text : String){

        val searchQuery = searchList.filter {
            it.official.startsWith(text,true)

        }

        countryList.clear()
        searchQuery.forEach {
            countryList.add(it)
        }
        notifyDataSetChanged()
    */

    }



    fun setListener(clickListenerForFlag: ClickListenerForFlag){
        clicklistener = clickListenerForFlag
    }

}

/*
 holder.setData(countryList[position]){
           clicklistener.clicked(it)
        }
 */