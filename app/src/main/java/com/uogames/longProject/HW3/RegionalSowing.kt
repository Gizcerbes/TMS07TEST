package com.uogames.longProject.HW3

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random


class RegionalSowing(
    private val numberOfStaff: Int
) {
    private val listCrop: Queue<MutableLiveData<Int>> = LinkedList()

    fun addCrop(cabbage: MutableLiveData<Int>) {
        listCrop.add(cabbage)
    }

    fun removeCrop(cabbage: MutableLiveData<Int>): Boolean {
        return listCrop.remove(cabbage)
    }

    fun startSowing(endSowing: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val random = Random
            while (listCrop.size > 0) {
                val cabbage = listCrop.poll()
                var progress = 0;
                while (progress < 1000) {
                    delay(1000)

                    val i = numberOfStaff / 2 + random.nextInt(numberOfStaff / 2)
                    if ((i + progress) < 1000) progress += numberOfStaff / 2 + random.nextInt(numberOfStaff / 2 )
                    else progress = 1000

                    cabbage.postValue(progress)
                }
            }
            endSowing()
        }
    }
}