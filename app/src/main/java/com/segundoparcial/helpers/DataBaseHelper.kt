package com.example.myapplication.helpers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context : Context)  : SQLiteOpenHelper(context, "names.db", null, 1) {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = (""" CREATE TABLE USUARIO (
            ID INTEGER PRIMARY KEY AUTOINCREMENT,
            NAME TEXT,
            TIPE TEXT,
            DESCRIPCION TEXT
            IMG TEXT
            )  """)
            p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertName(name : String, descripcion : String, tipe : String, img : String) : String{
        val db = this.writableDatabase
        /*
        val contentValue = ContentValues().apply {
            put("NAME", name)
        }
        */
        val contentValues = ContentValues()
        contentValues.put("NAME", name)
        contentValues.put("DESCRIPCION", descripcion)
        contentValues.put("TIPE", tipe)
        contentValues.put("IMG", img)
        val result = db.insert("USUARIO",  null, contentValues  )
        return if (result == (-1).toLong()) "Existe una falla" else "Inserción correcta"
    }

    fun selectAllName() : MutableList<String>{
        val userList = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM NAMES", null)
        if(cursor.moveToFirst()){
            do {
                val user = cursor.getString( cursor.getColumnIndexOrThrow("USUARIO") )
                userList.add(user)
            }while (cursor.moveToNext())
        }
        return userList
    }

    fun updateName(id : String , name : String) : String{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("NAME", name )
        val result = db.update("NAMES", contentValues , "id=?", arrayOf(id) )
        return if(result > 0) "Actualización exitosa" else "Error al actualizar"
    }

    fun deleteName(id : String) : String{
        val db = this.writableDatabase
        val result = db.delete("NAMES", "id=?", arrayOf(id))
        return if(result > 0) "Eliminación exitosa" else "Error al eliminar"
    }


}


















