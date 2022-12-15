package com.ozgursarki.apitest2.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.databinding.CountryRowImageBinding
import com.ozgursarki.apitest2.databinding.CountryRowTextBinding
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.CountryNameItem
import com.squareup.picasso.Picasso

sealed class CountryViewHolder(binding : View) : RecyclerView.ViewHolder(binding.rootView){

    class TextViewHolder(private val binding: CountryRowTextBinding) : CountryViewHolder(binding.countryName){
       fun bind(text: Countries.CountryName){
           val countryName = itemView.findViewById<TextView>(binding.countryName.id)
           countryName.text = text.name.official
       }
    }

    class ImageViewHolder(private val binding: CountryRowImageBinding) : CountryViewHolder(binding.imageView){
        fun bind(image: Countries.Flags){
            val countryImage = itemView.findViewById<ImageView>(binding.imageView.id)
            Picasso.get().load(image.flags.png).into(countryImage)
        }
    }


}