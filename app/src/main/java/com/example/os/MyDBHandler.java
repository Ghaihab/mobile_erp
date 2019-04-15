package com.example.os;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.os.DTOs.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ERB.db";
    private static final int DATABASE_VERSION = 1;

    private static MyDBHandler myDBHandler;


    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public static synchronized MyDBHandler getInstance(Context context) {

        if (myDBHandler == null) {
            myDBHandler = new MyDBHandler(context,
                    DATABASE_NAME, null, DATABASE_VERSION);
        }
        return myDBHandler;
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

    public String getLastToken(){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                "id",
                "access_token"
        };


        Cursor cursor = db.query(
                "Tokens",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null// The sort order
        );

        cursor.moveToNext();

        String access_token = cursor.getString(cursor.getColumnIndex("access_token"));

        return access_token;
    }

    public String getAuthToken(){

        return "Bearer " + this.getLastToken();
    }

    public User getAuthUser() {
        String token = this.getLastToken();
        String[] pieces = token.split("\\.");
        String b64payload = pieces[1];
        String jsonString = null;
        try {
            jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        Integer id = jsonObject.get("user").getAsJsonObject().get("id").getAsInt();
        String name = jsonObject.get("user").getAsJsonObject().get("name").getAsString();
        String email = jsonObject.get("user").getAsJsonObject().get("email").getAsString();
        String phone_number = jsonObject.get("user").getAsJsonObject().get("phone_number").getAsString();
        String ssn = jsonObject.get("user").getAsJsonObject().get("ssn").getAsString();
        String type = jsonObject.get("user").getAsJsonObject().get("type").getAsString();
        String gender = "Male";

        return new User(id, name, email, phone_number, ssn, type, gender);
    }

}

