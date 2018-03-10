package com.example.asp.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String DB_NAME = "Students";
    private static final String DB_TABLE_NAME = "students";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SQLiteDatabase myDB = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);

        myDB.execSQL("CREATE TABLE IF NOT EXISTS " + DB_TABLE_NAME + " (name VARCHAR  , age INT(3), id INT PRIMARY KEY)");
        myDB.execSQL(" INSERT INTO " +  DB_TABLE_NAME + "(name, age) VALUES ('Mustufa','55')");

        Cursor cursor = myDB.rawQuery("SELECT * FROM " + DB_TABLE_NAME,null);

        it nameIndex = cursor.getColumnIndex("name");
        int ageIndex = cursor.getColumnIndex("age");
        int idIndex = cursor.getColumnIndex("id");

        cursor.moveToFirst();

        do {

            Log.d(TAG, "onCreate: name " + cursor.getString(nameIndex));
            Log.d(TAG, "onCreate: age " + cursor.getInt(ageIndex));
            Log.d(TAG, "onCreate: id " + cursor.getInt(idIndex));

        }while (cursor.moveToNext());

    }
}
