package com.ozgursarki.apitest2.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.Countries
import com.squareup.picasso.Picasso

class ImageViewHolder(view:View) : RecyclerView.ViewHolder(view) {


    val countryImage = itemView.findViewById<ImageView>(R.id.country_image)

    fun setImage(country: Countries, clicked: (flags:Countries) -> Unit){
        Picasso.get().load(country.flags.png).into(countryImage)

        countryImage.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                clicked.invoke(country)
            }

        })

    }
}
