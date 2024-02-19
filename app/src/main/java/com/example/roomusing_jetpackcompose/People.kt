package com.example.roomusing_jetpackcompose

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "People")
data class People(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo("personID") var personID:Int,
                  @ColumnInfo("personNAME") var personName:String,
                  @ColumnInfo("personPHONE")var personPHONE:String)
