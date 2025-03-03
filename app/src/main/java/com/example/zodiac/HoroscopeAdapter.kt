package com.example.zodiac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class HoroscopeAdapter (val item : List<Horoscope>, val onClick: (Int)-> Unit) : Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.iten_horoscope,parent,false)
        return HoroscopeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = item[position]
        holder.render(horoscope)
        holder.itemView.setOnClickListener{
            onClick(position)
        }

    }


}
class HoroscopeViewHolder (view: View) : ViewHolder(view){
    val iconImageView: ImageView = view.findViewById(R.id.iconImageView)
    val nameTextView : TextView = view.findViewById(R.id.nameTextView)
    val dateTextView : TextView = view.findViewById(R.id.dateTextView)

    fun render(horoscope: Horoscope){

        iconImageView.setImageResource(horoscope.icon)
        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.date)
    }
}