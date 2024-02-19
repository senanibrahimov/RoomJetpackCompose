package com.example.roomusing_jetpackcompose

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [People::class], version = 1)
abstract class RoomDatabase:RoomDatabase() {

    abstract fun kisilerdao():Dao

    companion object{
        var Instance:com.example.roomusing_jetpackcompose.RoomDatabase?=null

        fun acsessdatabase(context: Context):com.example.roomusing_jetpackcompose.RoomDatabase?{
            if (Instance==null){
                synchronized(RoomDatabase::class){
                   Instance=Room.databaseBuilder(context.applicationContext,com.example.roomusing_jetpackcompose.RoomDatabase::class.java,"mysql.db").createFromAsset("mysql.db").build()
                }
            }
            return Instance
        }
    }
}