package com.ix.ibrahim7.excelreaderapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ix.ibrahim7.excelreaderapplication.R
import com.ix.ibrahim7.excelreaderapplication.model.WeatherSample
import com.ix.ibrahim7.excelreaderapplication.databinding.ItemWeatherDesignBinding


class WeatherAdapter(
    var data: MutableList<WeatherSample>
) :
        RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {


    class WeatherViewHolder(val item: ItemWeatherDesignBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(n: WeatherSample) {
            item.weather = n
            item.executePendingBindings()
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView_layout: ItemWeatherDesignBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_weather_design, parent, false
        )
        return WeatherViewHolder(itemView_layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        val currentItem = data[position]
        holder.bind(currentItem)

    }



}
