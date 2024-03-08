package com.example.wincaraxml

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION){

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "WincaraUserdb.db"

    }

    override fun onCreate(db: SQLiteDatabase) {
        db?.execSQL("create table users (user_name TEXT primary key, user_password TEXT, user_gender TEXT, user_department TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists users")
    }

    fun addUSer(user_name: String, user_password: String, user_gender: String, user_department:String){
        val db = this.writableDatabase
        val cv = ContentValues().apply {
            put("username", user_name)
            put("passwrd", user_password)
            put("user_gender", user_gender)
            put("department", user_department)

        }
        val result = db.insert("users", null, cv)
    }

}