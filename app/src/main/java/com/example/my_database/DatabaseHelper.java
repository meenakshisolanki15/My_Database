package com.example.my_database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME  = "student.db";
    public static final String TABLE_NAME  = "student_table";
    public static final String COL_1  = "ID";
    public static final String COL_2  = "NAME";
    public static final String COL_3  = "SURNAME";
    public static final String COL_4  = "MARKS";

    public DatabaseHelper(@Nullable MainActivity context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "  + TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String surname, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, surname);
        contentValues.put(COL_3, marks);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
