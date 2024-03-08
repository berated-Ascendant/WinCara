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
        db?.execSQL("create table users (username TEXT primary key, password TEXT, usergender TEXT, department TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists users")
    }

    fun addUSer(username: String, password: String, usergender: String, department:String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues().apply {
            put("username", username)
            put("password", password)
            put("usergender", usergender)
            put("department", department)

        }
        val result = db.insert("users", null, cv)
        if(result == -1.toLong()){
            return false
        }
        return true
    }

    fun checkuserpass(username: String, password: String ): Boolean {
        val db = this.writableDatabase
        val query = "select * from users where username = '$username' and password = '$password'"
        val cursor = db.rawQuery(query,null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

}