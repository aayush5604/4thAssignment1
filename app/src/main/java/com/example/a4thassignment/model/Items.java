package com.example.a4thassignment.model;

public class Items {
    int imgId;
    String desc;
    float price;

    public Items(int imgId, String desc, float price) {
        this.imgId = imgId;
        this.desc = desc;
        this.price = price;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
