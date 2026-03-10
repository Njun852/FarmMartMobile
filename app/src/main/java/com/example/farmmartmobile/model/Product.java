package com.example.farmmartmobile.model;

import java.time.LocalDateTime;

public class Product {
    private String name, description;
    private String imageUrl;
    LocalDateTime createdTime, editedTime;
    private int productId;
    private int quantity;
    private int sellPrice;
    private ProductCategory category;

    public Product(String name, String description, LocalDateTime createdTime, LocalDateTime editedTime, int productId, int quantity, int sellPrice, ProductCategory category) {
        this.name = name;

        this.description = description;
        this.createdTime = createdTime;
        this.editedTime = editedTime;
        this.productId = productId;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getEditedTime() {
        return editedTime;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
