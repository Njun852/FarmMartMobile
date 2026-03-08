package com.example.farmmartmobile.model;

import java.time.LocalDateTime;

public class InventoryLog {
    private int logId;
    private LocalDateTime createdTime;
    private String productName, reason;
    private int change;
    private int quantityBefore;
    private User user;
}
