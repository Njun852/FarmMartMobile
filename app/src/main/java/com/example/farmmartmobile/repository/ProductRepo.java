package com.example.farmmartmobile.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farmmartmobile.model.Product;
import com.example.farmmartmobile.model.ProductCategory;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProductRepo {
    private static ProductRepo instance;
    MutableLiveData<ArrayList<Product>> products;

    private ProductRepo() {
        products = new MutableLiveData<>();
        loadDataFromDB();
    }

    public LiveData<ArrayList<Product>> getProducts() {
        return products;
    }

    private void loadDataFromDB() {
            ArrayList<Product> p = new ArrayList<>();
            p.add(new Product("Apple", "Fresh red gala apples", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 100, new ProductCategory()));
            p.add(new Product("Banana", "Organic cavendish bananas", LocalDateTime.now(), LocalDateTime.now(), 2, 0, 300, new ProductCategory()));
            p.add(new Product("Cherry", "Sweet dark red cherries", LocalDateTime.now(), LocalDateTime.now(), 3, 4, 50, new ProductCategory()));
            p.add(new Product("Dragonfruit", "Exotic pink dragonfruit", LocalDateTime.now(), LocalDateTime.now(), 4, 3, 20, new ProductCategory()));
            p.add(new Product("Eggplant", "Large purple eggplants", LocalDateTime.now(), LocalDateTime.now(), 5, 2, 45, new ProductCategory()));
            p.add(new Product("Fig", "Fresh mediterranean figs", LocalDateTime.now(), LocalDateTime.now(), 6, 0, 150, new ProductCategory()));
            p.add(new Product("Grapes", "Seedless green grapes", LocalDateTime.now(), LocalDateTime.now(), 7, 2, 80, new ProductCategory()));
            p.add(new Product("Honeydew", "Sweet green honeydew melon", LocalDateTime.now(), LocalDateTime.now(), 8, 3, 15, new ProductCategory()));
            p.add(new Product("Iceberg Lettuce", "Crispy garden lettuce", LocalDateTime.now(), LocalDateTime.now(), 9, 1, 60, new ProductCategory()));
            p.add(new Product("Jackfruit", "Large tropical jackfruit", LocalDateTime.now(), LocalDateTime.now(), 10, 5, 10, new ProductCategory()));

            products.setValue(p);
    }
    public void addProduct(Product product) {
        new Thread(()->{
            if(products != null){
                ArrayList<Product> p = products.getValue();
                p.add(product);
                products.postValue(p);
            }
        }).start();
    }
    public static synchronized ProductRepo getInstance() {
        if(instance == null) {
            instance = new ProductRepo();
        }
        return  instance;
    }
}
