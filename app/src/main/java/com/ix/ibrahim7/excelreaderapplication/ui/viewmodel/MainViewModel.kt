package com.ix.ibrahim7.excelreaderapplication.ui.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ix.ibrahim7.excelreaderapplication.R
import com.ix.ibrahim7.excelreaderapplication.adapter.WeatherAdapter
import com.ix.ibrahim7.excelreaderapplication.model.WeatherSample
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val TAG ="MainViewModel"

    val dataWeatherLiveData = MutableLiveData<ArrayList<WeatherSample>>()
    lateinit var line:String

    private fun getData(context: Context) {
        GlobalScope.launch {
            try {
                val arrayList= ArrayList<WeatherSample>()
                val input = context.resources.openRawResource(R.raw.data)
                val reader = BufferedReader(InputStreamReader(input, Charset.forName("UTF-8")))
                var number =0
                while (reader.readLine() != null) {
                    line = reader.readLine()
                    val list = line.split(",")
                    arrayList.add(WeatherSample(list[0], list[1], list[2]))
                    number++
                    if (number <= line.length-1){
                        dataWeatherLiveData.postValue(arrayList)
                    }
                }
            } catch (e: IOException) {
                Log.v("$TAG error", e.message.toString())
            }
        }
    }

    init {
        getData(application)
    }


}