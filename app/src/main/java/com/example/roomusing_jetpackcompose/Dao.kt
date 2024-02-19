package com.example.roomusing_jetpackcompose

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
     @Query("SELECT*FROM people")
    suspend fun allperson():List<People>

    @Insert
    suspend fun  savepeople(people: People)

    @Update
    suspend fun updatePeople(people: People)

    @Delete
    suspend fun deletedata(people: People)


    @Query("SELECT*FROM people ORDER BY RANDOM() LIMIT 3")
    suspend fun randomandlimit():List<People>

    @Query("SELECT*FROM people WHERE personNAME LIKE  '%' || :value  ||'%'")
    suspend fun search(value:String):List<People>


    @Query("SELECT*FROM people WHERE personID= :s")
    suspend fun valuename(s:Int):People


    @Query("SELECT count(*) FROM people")
    suspend fun counter():Int
}