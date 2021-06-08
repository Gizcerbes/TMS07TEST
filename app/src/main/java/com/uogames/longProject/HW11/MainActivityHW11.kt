package com.uogames.longProject.HW11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.uogames.longProject.HW11.data.entities.Countries
import com.uogames.longProject.HW11.data.mappers.CountriesMapper
import com.uogames.longProject.HW11.data.repository.HolidaysRepository
import com.uogames.longProject.HW11.recycler.HolidayRecycler
import com.uogames.longProject.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityHW11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw11)

        HolidaysRepository().loadCountries()
            .subscribeOn(Schedulers.io())
            .map {
                CountriesMapper().map(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it?.let {
                    val recycler = findViewById<RecyclerView>(R.id.recycler_hw11)
                    recycler.adapter = HolidayRecycler(R.layout.fragment_recycler_item_holiday, it.countries)
                }
            },{
            })

    }
}