package com.ozgursarki.apitest2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.ClickListenerForFlag
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.Flags
import com.ozgursarki.apitest2.model.Title
import com.ozgursarki.apitest2.viewholder.CountryViewHolder
import com.ozgursarki.apitest2.viewholder.ImageViewHolder
import com.ozgursarki.apitest2.viewholder.TitleViewHolder

class CountryListAdapter(private var countryList: ArrayList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var clicklistener:ClickListenerForFlag
    private   var searchList : ArrayList<Any> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.country_title,parent,false)
            TitleViewHolder(view)
        }else {
            val view= LayoutInflater.from(parent.context).inflate(R.layout.country_image,parent,false)
            ImageViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is ImageViewHolder -> holder.setImage(countryList[position] as Countries){
                clicklistener.clicked(it)
            }
            is TitleViewHolder -> holder.setText(countryList[position] as Title)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(countryList[position]){
            is Title -> 0
            is Countries -> 1
            else -> 0
        }
    }

    fun setList(newList: ArrayList<Countries>){
        newList.forEach{
            val title: Title = Title(it.name.official)
            countryList.add(title)
            searchList.add(title)
            searchList.add(it)
            countryList.add(it)
        }
        notifyDataSetChanged()
    }



    fun searchChange(text : String){
        val searchQuery = searchList.filter {
            if(it is Title){
                it.title.startsWith(text,true)
            }else {
                (it as Countries).name.official.startsWith(text,true)
            }

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