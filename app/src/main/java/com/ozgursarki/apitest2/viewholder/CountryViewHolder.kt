package com.ozgursarki.apitest2.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.CountryNameItem

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun setData(country: CountryNameItem, clicked: (country: CountryNameItem) -> Unit){
        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val countryLang = itemView.findViewById<TextView>(R.id.country_lang)

        countryName.text = country.name.toString()
        countryLang.text = country.languages.toString()

        countryName.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                clicked.invoke(country)
            }

        })
    }
}