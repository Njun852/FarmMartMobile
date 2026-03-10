package com.example.farmmartmobile.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.farmmartmobile.model.Product;
import com.example.farmmartmobile.repository.ProductRepo;

import java.util.ArrayList;

public class HomeViewModel extends AndroidViewModel {

    ProductRepo productRepo = ProductRepo.getInstance();
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Product>> getProducts() {
        return productRepo.getProducts();
    }

}
