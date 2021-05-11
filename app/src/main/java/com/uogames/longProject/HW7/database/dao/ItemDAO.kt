package com.uogames.longProject.HW7.database.dao

import androidx.room.*
import com.uogames.longProject.HW7.database.entity.Item

@Dao
interface ItemDAO {

    @Insert
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun update(item: Item)

    @Query("SELECT * FROM items_table")
    suspend fun getAll(): List<Item>

    @Query("SELECT * FROM items_table WHERE name LIKE '%' || :nameItems || '%'")
    suspend fun fiendItem(nameItems: String): List<Item>

    @Query("SELECT * FROM items_table WHERE id = :id")
    suspend fun getItemById(id: Int): List<Item>

}