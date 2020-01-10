package com.example.a4thassignment.model;

public class Items {
    String imgName;
    String ProductName;
    float price;

    public Items(String imgName, String productName, float price) {
        this.imgName = imgName;
        ProductName = productName;
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}