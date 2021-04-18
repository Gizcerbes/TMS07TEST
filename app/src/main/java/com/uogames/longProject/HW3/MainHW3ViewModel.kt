package com.uogames.longProject.HW3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainHW3ViewModel : ViewModel() {
    private var ran = false

    val countCerealMinsk = MutableLiveData<Int>(0)
    val countPotatoesMinsk = MutableLiveData<Int>(0)
    val countCabbageMinsk = MutableLiveData<Int>(0)
    val countBeetMinsk = MutableLiveData<Int>(0)
    val endSowingMinsk = MutableLiveData<Boolean>(false)

    val countCerealViciebsk = MutableLiveData<Int>(0)
    val countPotatoesViciebsk = MutableLiveData<Int>(0)
    val countCabbageViciebsk = MutableLiveData<Int>(0)
    val countBeetViciebsk = MutableLiveData<Int>(0)
    val endSowingViciebsk = MutableLiveData<Boolean>(false)

    val countCerealHrodna = MutableLiveData<Int>(0)
    val countPotatoesHrodna = MutableLiveData<Int>(0)
    val countCabbageHrodna = MutableLiveData<Int>(0)
    val countBeetHrodna = MutableLiveData<Int>(0)
    val endSowingHrodna = MutableLiveData<Boolean>(false)

    val countCerealBrest = MutableLiveData<Int>(0)
    val countPotatoesBrest = MutableLiveData<Int>(0)
    val countCabbageBrest = MutableLiveData<Int>(0)
    val countBeetBrest = MutableLiveData<Int>(0)
    val endSowingBrest = MutableLiveData<Boolean>(false)

    val countCerealHomiel = MutableLiveData<Int>(0)
    val countPotatoesHomiel = MutableLiveData<Int>(0)
    val countCabbageHomiel = MutableLiveData<Int>(0)
    val countBeetHomiel = MutableLiveData<Int>(0)
    val endSowingHomiel = MutableLiveData<Boolean>(false)

    val countCerealMahilo = MutableLiveData<Int>(0)
    val countPotatoesMahilo = MutableLiveData<Int>(0)
    val countCabbageMahilo = MutableLiveData<Int>(0)
    val countBeetMahilo = MutableLiveData<Int>(0)
    val endSowingMahilo = MutableLiveData<Boolean>(false)


    fun start(){
        if (ran) return
        ran = true

        val random = Random
        val regionMinsk = RegionalSowing(50 + random.nextInt(200))
        regionMinsk.addCrop(countCerealMinsk)
        regionMinsk.addCrop(countPotatoesMinsk)
        regionMinsk.addCrop(countCabbageMinsk)
        regionMinsk.addCrop(countBeetMinsk)

        val regionViciebsk = RegionalSowing(50 + random.nextInt(200))
        regionViciebsk.addCrop(countCerealViciebsk)
        regionViciebsk.addCrop(countPotatoesViciebsk)
        regionViciebsk.addCrop(countCabbageViciebsk)
        regionViciebsk.addCrop(countBeetViciebsk)

        val regionHrodna = RegionalSowing(50 + random.nextInt(200))
        regionHrodna.addCrop(countCerealHrodna)
        regionHrodna.addCrop(countPotatoesHrodna)
        regionHrodna.addCrop(countCabbageHrodna)
        regionHrodna.addCrop(countBeetHrodna)

        val regionBrest = RegionalSowing(50 + random.nextInt(200))
        regionBrest.addCrop(countCerealBrest)
        regionBrest.addCrop(countPotatoesBrest)
        regionBrest.addCrop(countCabbageBrest)
        regionBrest.addCrop(countBeetBrest)

        val regionHomiel = RegionalSowing(50 + random.nextInt(200))
        regionHomiel.addCrop(countCerealHomiel)
        regionHomiel.addCrop(countPotatoesHomiel)
        regionHomiel.addCrop(countCabbageHomiel)
        regionHomiel.addCrop(countBeetHomiel)

        val regionMahilo = RegionalSowing(50 + random.nextInt(200))
        regionMahilo.addCrop(countCerealMahilo)
        regionMahilo.addCrop(countPotatoesMahilo)
        regionMahilo.addCrop(countCabbageMahilo)
        regionMahilo.addCrop(countBeetMahilo)

        regionMinsk.startSowing { endSowingMinsk.postValue(true) }
        regionViciebsk.startSowing { endSowingViciebsk.postValue(true) }
        regionHrodna.startSowing { endSowingHrodna.postValue(true) }
        regionBrest.startSowing { endSowingBrest.postValue(true) }
        regionHomiel.startSowing { endSowingHomiel.postValue(true) }
        regionMahilo.startSowing { endSowingMahilo.postValue(true) }
    }



}