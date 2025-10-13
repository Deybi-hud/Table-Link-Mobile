package com.example.table_link_movile.Data.remote.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.table_link_movile.Data.remote.dao.UserDao


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun userDao(): UserDao

    companion object{

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "users_db"
                ).build().also { INSTANCE = it }
            }
        }

    }


}