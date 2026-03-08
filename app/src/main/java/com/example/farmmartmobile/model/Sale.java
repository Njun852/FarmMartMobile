package com.example.farmmartmobile.model;

import java.time.LocalDateTime;

public class Sale {
    private int saleId;
    private User customer;
    private LocalDateTime createdTime;
    private int price;
    private Product product;
    private Address deliveryAddress;
}
