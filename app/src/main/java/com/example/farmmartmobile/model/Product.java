package com.example.farmmartmobile.model;

import java.time.LocalDateTime;

public class Product {
    private String name, description;
    private String imageUrl;
    LocalDateTime createdTime, editedTime;
    private int productId;
    private int sellPrice;
    private ProductCategory category;
}
