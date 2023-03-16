package com.example.thuchanh1.model;

public class Object {
    private int img;
    private String name, des;
    private double price;

    public Object() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Object(int img, String name, String des, double price) {
        this.img = img;
        this.name = name;
        this.des = des;
        this.price = price;
    }

}
