package com.example.mvvmcities.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmcities.databinding.ActivityMainBinding
import com.example.mvvmcities.viewmodel.CityViewmodel

class MainActivity : AppCompatActivity() {

    private lateinit var binder : ActivityMainBinding
    private val model : CityViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

    }

    override fun onResume() {
        super.onResume()
        model.getCityData().observe(this, Observer { city->
            binder.cityImage.setImageResource(city.img)
            binder.cityNameTV.text = city.name
            binder.cityPopulationTV.text = city.population.toString()

        })
    }
}