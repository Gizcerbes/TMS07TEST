package com.uogames.longProject.HW7

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uogames.longProject.HW7.database.MyDatabase
import com.uogames.longProject.HW7.database.entity.Item
import com.uogames.longProject.HW7.repository.MyRepository

class MainViewModelHW7(application: Application) : AndroidViewModel(application) {

    private val myRepository = MyRepository(MyDatabase.getINSTANCE(application))

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun insert(item: Item){
        myRepository.insert(item)
    }

    fun getAll(){
       myRepository.loadAll { _itemList.postValue(it)       }
    }




}