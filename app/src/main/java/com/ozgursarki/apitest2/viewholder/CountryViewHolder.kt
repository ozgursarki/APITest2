package com.ozgursarki.apitest2.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.CountryNameItem
import com.squareup.picasso.Picasso

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun setData(country: Countries, clicked: (flags:Countries) -> Unit){
        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val countryImage = itemView.findViewById<ImageView>(R.id.country_image)

        Picasso.get().load(country.flags.png).into(countryImage);

        countryName.text = country.name.official

        countryImage.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                clicked.invoke(country)
            }

        })
    }
}