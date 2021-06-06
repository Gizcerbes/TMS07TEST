package com.uogames.longProject.HW11.data.mappers

import com.uogames.longProject.HW11.data.dto.CountriesRequest
import com.uogames.longProject.HW11.data.entities.Countries

class CountriesMapper : Mapper<CountriesRequest, Countries> {
    override fun map(from: CountriesRequest): Countries {
        return Countries(ArrayList<Countries.Country>().let { list ->
            from.countries?.forEach {
                list.add(
                    Countries.Country(
                        code = it?.code.orEmpty(),
                        flag = it?.flag.orEmpty(),
                        name = it?.name.orEmpty()
                    )
                )
            }
            list
        })
    }
}