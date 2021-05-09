package com.uogames.longProject.HW4

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uogames.longProject.R

class MainViewModelHW4 : ViewModel {

    private val mainFragment = MainFragmentHW4()
    private val addSnowdropFragment = AddSnowdropFragmentHW4()
    private val listSnowdropFragment = ListSnowdropFragmentHW4()
    private val snowdropInfoFragment = SnowdropInfoFragment()

    val selectedFragment = MutableLiveData<Fragment>(mainFragment)

    constructor() {

        mainFragment.addSnowdropListener { selectedFragment.postValue(addSnowdropFragment) }
        mainFragment.addWatchSnowdropsListener { selectedFragment.postValue(listSnowdropFragment) }

        addSnowdropFragment.addSnowdropListener { view, snowdrop ->
            listSnowdropFragment.addSnowdrop(snowdrop)
            selectedFragment.postValue(mainFragment)
        }
        addSnowdropFragment.addOnBackListener { selectedFragment.postValue(mainFragment) }

        listSnowdropFragment.addOnBackListener { selectedFragment.postValue(mainFragment) }
        listSnowdropFragment.addOnSelectListener { view, snowdrop ->
            snowdropInfoFragment.setSnowdrop(snowdrop)
            selectedFragment.postValue(snowdropInfoFragment)
        }

        snowdropInfoFragment.addOnBackListener { selectedFragment.postValue(listSnowdropFragment) }


    }

}