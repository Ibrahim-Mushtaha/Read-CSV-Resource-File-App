package com.ix.ibrahim7.excelreaderapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ix.ibrahim7.excelreaderapplication.R
import com.ix.ibrahim7.excelreaderapplication.adapter.WeatherAdapter
import com.ix.ibrahim7.excelreaderapplication.databinding.ActivityMainBinding
import com.ix.ibrahim7.excelreaderapplication.model.WeatherSample
import com.ix.ibrahim7.excelreaderapplication.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {


    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val weatherAdapter by lazy {
        WeatherAdapter(ArrayList())
    }

    lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        viewModel.dataWeatherLiveData.observe(this, Observer {weather->
            weatherAdapter.data.addAll(weather)
            weatherAdapter.notifyDataSetChanged()
        })

        mbinding.listItem.apply {
            adapter=weatherAdapter
        }
    }



}