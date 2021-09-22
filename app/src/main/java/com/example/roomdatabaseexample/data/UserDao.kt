package com.example.roomdatabaseexample.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabaseexample.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Update
   fun updateUser(user: User)
    @Delete
   fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
     fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE firstName LIKE :searchQuery OR lastName LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<User>>

}