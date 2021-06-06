package com.uogames.longProject.HW11.recycler

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.uogames.longProject.HW11.data.entities.Countries
import com.uogames.longProject.HW11.data.mappers.CountriesMapper
import com.uogames.longProject.HW11.data.mappers.HolidaysMapper
import com.uogames.longProject.HW11.data.repository.HolidaysRepository
import com.uogames.longProject.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class HolidayRecycler(layout: Int, items: List<Countries.Country>) :
    SimpleRecyclerAdapter<Countries.Country, HolidayRecycler.HolidayHolder>(layout, items) {

    inner class HolidayHolder(view: View) : SimpleViewHolder<Countries.Country>(view) {
        override fun setData(itemView: View, any: Countries.Country) {
            val date = itemView.findViewById<TextView>(R.id.holiday_date)
            val info = itemView.findViewById<TextView>(R.id.holiday_info)
            val progress = itemView.findViewById<ProgressBar>(R.id.holiday_progress)

            itemView.findViewById<TextView>(R.id.country_name).text = any.name
            Picasso.get().load(any.flag).into(itemView.findViewById<ImageView>(R.id.country_flag))

            val d = Date()
            val mouthFormat = SimpleDateFormat("M")
            val dayFormat = SimpleDateFormat("d")


            date.apply { visibility = View.INVISIBLE }
            info.apply { visibility = View.INVISIBLE }
            progress.apply { visibility = View.VISIBLE }

            Log.e("tag", any.code)
            Log.e("tag", mouthFormat.format(d))
            Log.e("tag", dayFormat.format(d))

            HolidaysRepository().loadFirstHoliday(
                any.code,
                "2020",
                mouthFormat.format(d),
                dayFormat.format(d)
            )
                .subscribeOn(Schedulers.io())
                .map {
                    HolidaysMapper().map(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let {
                        date.apply {
                            visibility = View.VISIBLE
                            text = it.holidays[0].date
                        }
                        info.apply {
                            visibility = View.VISIBLE
                            text = it.holidays[0].name
                        }
                        progress.apply {
                            visibility = View.INVISIBLE
                        }
                    }
                }, {
                    Log.e("tag", it.localizedMessage.toString())
                })

        }

    }

    override fun createViewHolder(view: View): HolidayHolder {
        return HolidayHolder(view)
    }

}