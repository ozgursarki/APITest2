package com.ozgursarki.apitest2.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.apitest2.R
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.Name
import com.ozgursarki.apitest2.model.Title

class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var itemClickListener : ((view: View, item: Countries, position:Int) -> Unit)? = null
    var countryTitle = itemView.findViewById<TextView>(R.id.country_title)
    fun setText(title: Title){
        countryTitle.text = title.title

    }
}