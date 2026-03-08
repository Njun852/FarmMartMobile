package com.example.farmmartmobile.model;

public class Address {
    private int userId, addressId;
    private String street, barangay, city, province, postalCode;

    public Address(int userId, int addressId, String street, String barangay, String city, String province, String postalCode) {
        this.userId = userId;
        this.addressId = addressId;
        this.street = street;
        this.barangay = barangay;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public int getUserId() {
        return userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getBarangay() {
        return barangay;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
