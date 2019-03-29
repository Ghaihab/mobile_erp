package com.example.os;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ERB.db";
    private static final int DATABASE_VERSION = 1;

    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTokenTable());
    }

    private String createTokenTable()
    {
        return "CREATE TABLE Tokens (id INTEGER PRIMARY KEY AUTOINCREMENT, access_token TEXT)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addToken(String token){

        ContentValues values = new ContentValues();
        values.put("access_token", token);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Tokens", null, values);
        db.close();
    }

    public boolean deleteTokens(){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Tokens", null, null) > 0;
    }

}

