package com.uogames.longProject.HW11.data.mappers

import com.uogames.longProject.HW11.data.dto.HolidaysRequest
import com.uogames.longProject.HW11.data.entities.Holidays

class HolidaysMapper : Mapper<HolidaysRequest, Holidays> {
    override fun map(from: HolidaysRequest): Holidays {
        return Holidays(ArrayList<Holidays.Holiday>().let { list ->
            from.holidays?.forEach {
                list.add(
                    Holidays.Holiday(
                        date = it?.date.orEmpty(),
                        name = it?.name.orEmpty()
                    )
                )
            }
            list
        })
    }
}