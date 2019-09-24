package br.com.bancodedadossqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProdutoSqlHelper(context: Context):
SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {

        sqLiteDatabase?.execSQL (
            "CREATE TABLE $TABLE_NAME ("+
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "$COLUMN_NAME TEXT NOT NULL, "+
                    "$COLUMN_VALUE REAL)")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}

