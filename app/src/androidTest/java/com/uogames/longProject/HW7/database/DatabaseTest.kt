package com.uogames.longProject.HW7.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.uogames.longProject.HW7.database.dao.ItemDAO
import com.uogames.longProject.HW7.database.entity.Item
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DatabaseTest {

    private lateinit var itemDao: ItemDAO

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val db = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries().build()
        itemDao = db.itemDAO()
    }

    @Test
    fun insertItem_returnTrue() {
        val item = Item(
            name = "Petya",
            description = "description",
            image = "img",
            dateOpen = 1,
            startPay = 10.0,
            currentParticipant = "Petya"
        )
        runBlocking {
            itemDao.insert(item)
            Assert.assertTrue(itemDao.getAll().contains(item))
        }
    }

    @Test
    fun deleteItem_returnFalse() {
        val item = Item(
            name = "Petya",
            description = "description",
            image = "img",
            dateOpen = 1,
            startPay = 10.0,
            currentParticipant = "Petya"
        ).apply {
            id = 1
        }
        runBlocking {
            itemDao.insert(item)
            itemDao.delete(item)
            Assert.assertFalse(itemDao.getAll().contains(item))
        }
    }

    @Test
    fun updateItem_returnTrue() {
        runBlocking {
            val item = Item(
                name = "Petya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Petya"
            ).apply {
                id = 1
            }
            itemDao.insert(item)
            item.currentParticipant = "Vasya"
            itemDao.update(item)
            Assert.assertTrue(itemDao.getAll().contains(item))
        }
    }

    @Test
    fun fiendItem_returnTrue() {
        runBlocking {
            val item1 = Item(
                name = "Petya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Petya"
            ).apply {
                id = 1
            }
            val item2 = Item(
                name = "Vasya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Vasya"
            ).apply {
                id = 2
            }
            val item3 = Item(
                name = "Fedya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Vasya"
            ).apply {
                id = 3
            }

            itemDao.insert(item1)
            itemDao.insert(item2)
            itemDao.insert(item3)

            Assert.assertTrue(itemDao.fiendItem("pe").get(0) == item1)
            Assert.assertTrue(itemDao.fiendItem("va").get(0) == item2)
            Assert.assertTrue(itemDao.fiendItem("fe").get(0) == item3)
            var result = itemDao.fiendItem("e")
            Assert.assertTrue(result.size == 2)
            Assert.assertTrue(result.contains(item1))
            Assert.assertTrue(result.contains(item3))
            result = itemDao.fiendItem("ya")
            Assert.assertTrue(result.size == 3)
        }
    }

    @Test
    fun getItemItemById_returnTrue() {
        runBlocking {
            val item1 = Item(
                name = "Petya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Petya"
            ).apply {
                id = 1
            }
            val item2 = Item(
                name = "Vasya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Vasya"
            ).apply {
                id = 20
            }
            val item3 = Item(
                name = "Fedya",
                description = "description",
                image = "img",
                dateOpen = 1,
                startPay = 10.0,
                currentParticipant = "Vasya"
            ).apply {
                id = 3
            }

            itemDao.insert(item1)
            itemDao.insert(item2)
            itemDao.insert(item3)

            Assert.assertTrue(itemDao.getItemById(20).get(0) == item2)
        }
    }

}