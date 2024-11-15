package com.example.myapplication.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context : Context)  : SQLiteOpenHelper(context, "names.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = (""" CREATE TABLE USUARIO (
            ID INTEGER PRIMARY KEY AUTOINCREMENT,
            NAME TEXT,
            DESCRIPCION TEXT
            IMG TEXT
            )  """)
            p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertName(name : String, descripcion : String, img : String) : String{
        val db = this.writableDatabase
        /*
        val contentValue = ContentValues().apply {
            put("NAME", name)
        }
        */
        val contentValues = ContentValues()
        contentValues.put("NAME", name)
        contentValues.put("DESCRIPCION", descripcion)
        contentValues.put("IMG", img)
        val result = db.insert("USUARIO",  null, contentValues  )
        return if (result == (-1).toLong()) "Existe una falla" else "Inserción correcta"
    }

    fun selectAllName() : MutableList<String>{
        val nameList = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM NAMES", null)
        if(cursor.moveToFirst()){
            do {
                val name = cursor.getString( cursor.getColumnIndexOrThrow("NAME") )
                nameList.add(name)
            }while (cursor.moveToNext())
        }
        return nameList
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


















