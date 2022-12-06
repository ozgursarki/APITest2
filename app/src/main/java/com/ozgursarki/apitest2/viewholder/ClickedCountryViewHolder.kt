package com.ozgursarki.apitest2.viewholder

import android.app.Application
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.ClickedFlag
import com.squareup.picasso.Picasso

class ClickedCountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun getFlagInfo(info : ClickedFlag){
        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val countryImage = itemView.findViewById<ImageView>(R.id.country_image)
        val countryRegion = itemView.findViewById<TextView>(R.id.country_region)
        val countryLang = itemView.findViewById<TextView>(R.id.country_lang)
        val countryCurrency = itemView.findViewById<TextView>(R.id.country_currency)

        Picasso.get().load("https://restcountries.com/v3.1/all/flags").into(countryImage)

        countryName.text = info.name.official
        countryRegion.text = info.region
        countryLang.text = info.languages.toString()
        countryCurrency.text = info.currencies.toString()


    }
}