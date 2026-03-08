package com.example.farmmartmobile.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.farmmartmobile.model.User;
import com.example.farmmartmobile.model.UserType;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FarmMartMobile.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserContract.CREATE_TABLE);
    }

    public long registerUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserContract.COLUMN_USER_TYPE, user.getType().toString());
        values.put(UserContract.COLUMN_FIRST_NAME, user.getFirstName());
        values.put(UserContract.COLUMN_LAST_NAME, user.getLastName());
        values.put(UserContract.COLUMN_EMAIL, user.getEmail());
        values.put(UserContract.COLUMN_PHONE_NUMBER, user.getPhoneNumber());
        values.put(UserContract.COLUMN_PASSWORD, user.getPassword());

        long createdTime = user.getCreatedTime().toEpochSecond(ZoneOffset.UTC);
        long updatedTime = user.getUpdatedTime().toEpochSecond(ZoneOffset.UTC);

        values.put(UserContract.COLUMN_CREATED_TIME, createdTime);
        values.put(UserContract.COLUMN_UPDATED_TIME, updatedTime);
        long id = db.insert(UserContract.TABLE_NAME, null, values);
        return id;
    }

    public User logIn(String email, String password) {
        User user = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+UserContract.TABLE_NAME+
                " WHERE "+UserContract.COLUMN_EMAIL +" = ? AND "+UserContract.COLUMN_PASSWORD +" = ?",
                new String[]{email, password});

        if(cursor.moveToFirst()) {
            user = new User(cursor.getInt(0), cursor.getString(1),
                    UserType.valueOf(cursor.getString(2)), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), LocalDateTime.ofEpochSecond(cursor.getLong(8), 0, ZoneOffset.UTC),
                    LocalDateTime.ofEpochSecond(cursor.getLong(9), 0, ZoneOffset.UTC)
                    );
        }
        cursor.close();
        db.close();
        return user;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserContract.DELETE_TABLE);
        db.close();
    }
}
