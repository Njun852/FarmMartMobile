package com.example.farmmartmobile.local;

public final class UserContract {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static  final String COLUMN_PROFILE_IMG_URL = "profile_img_url";
    public static final String COLUMN_USER_TYPE = "user_type";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CREATED_TIME = "created_time";
    public static final String COLUMN_UPDATED_TIME = "updated_time";

    public static final String CREATE_TABLE =
            "CREATE TABLE "+TABLE_NAME+" ("+
            COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_PROFILE_IMG_URL+" TEXT, "+
            COLUMN_USER_TYPE+" TEXT, "+
            COLUMN_FIRST_NAME+" TEXT, "+
            COLUMN_LAST_NAME+" TEXT, "+
            COLUMN_EMAIL+" TEXT, "+
            COLUMN_PHONE_NUMBER+" TEXT, "+
            COLUMN_PASSWORD+" TEXT, "+
            COLUMN_CREATED_TIME+" TEXT, "+
            COLUMN_UPDATED_TIME+" TEXT" +
            ")";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
}
