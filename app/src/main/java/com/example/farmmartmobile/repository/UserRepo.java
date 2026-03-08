package com.example.farmmartmobile.repository;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farmmartmobile.local.DatabaseHelper;
import com.example.farmmartmobile.model.User;

public class UserRepo {
    private static UserRepo instance;
    private final DatabaseHelper dbHelper;
    private final MutableLiveData<User> user = new MutableLiveData<>();
    private static final String KEY_SAVED_EMAIL = "saved_email";
    private static final String KEY_SAVED_PASSWORD = "saved_password";
    private final SharedPreferences prefs;

    private UserRepo(Context context) {
        dbHelper = new DatabaseHelper(context);
        this.prefs = context.getApplicationContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        login(this.prefs.getString(KEY_SAVED_EMAIL, ""), this.prefs.getString(KEY_SAVED_PASSWORD, ""));
    }
    public static synchronized UserRepo getInstance(Context context) {
        if(instance == null) {
            instance = new UserRepo(context);
        }
        return instance;
    }
    public MutableLiveData<User> getUser() {
        return user;
    }
    public void register(User u) {
        new Thread(()->{
            int id = (int) dbHelper.registerUser(u);
            u.setUserId(id);
            user.postValue(u);
        }).start();
    }
    public void login(String email, String password) {
        new Thread(()->{
            User loggedIn = dbHelper.logIn(email, password);
            if(loggedIn != null) {
                user.postValue(loggedIn);
                prefs.edit()
                        .putString(KEY_SAVED_EMAIL, email)
                        .putString(KEY_SAVED_PASSWORD, password)
                        .apply();

            }else {
                logOut();
            }
        }).start();
    }
    public void logOut(){
        user.postValue(null);
        prefs.edit().clear().apply();
    }

}
