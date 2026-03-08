package com.example.farmmartmobile.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.farmmartmobile.model.User;
import com.example.farmmartmobile.repository.UserRepo;

public class UserViewModel extends AndroidViewModel {
    private final UserRepo userRepo;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = UserRepo.getInstance(application);
    }

    public void login(String email, String password) {
        userRepo.login(email, password);
    }
    public MutableLiveData<User> getUser(){
        return userRepo.getUser();
    }
    public void register(User user) {
        userRepo.register(user);
    }
    public void logOut() {
        userRepo.logOut();
    }
}
