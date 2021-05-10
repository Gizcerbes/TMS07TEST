package com.uogames.longProject.HW7.repository

import com.uogames.longProject.HW7.database.MyDatabase
import com.uogames.longProject.HW7.database.entity.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyRepository(
    private val database: MyDatabase
) {

    private val dao = database.itemDAO()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(item: Item) {
        ioScope.launch { dao.insert(item) }
    }

    fun loadAll(block: (List<Item>) -> Unit) {
        ioScope.launch { block(withContext(Dispatchers.IO) { dao.getAll() }) }
    }

    fun delete(item: Item) {
        ioScope.launch { dao.delete(item) }
    }

    fun update(item: Item) {
        ioScope.launch { dao.update(item) }
    }

    fun fiendItem(itemName: String, block: (List<Item>) -> Unit) {
        ioScope.launch { block(withContext(Dispatchers.IO) { dao.fiendItem(itemName) }) }
    }

}