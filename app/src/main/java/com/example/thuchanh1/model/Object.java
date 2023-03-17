package com.example.thuchanh1.model;

public class Object {
    public static String ONLINE="online",OFF="Off";
    private int img;
    private String name,kyhan,hinhthuc;
    private double laixuat;

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

    public String getKyhan() {
        return kyhan;
    }

    public void setKyhan(String kyhan) {
        this.kyhan = kyhan;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public double getLaixuat() {
        return laixuat;
    }

    public void setLaixuat(double laixuat) {
        this.laixuat = laixuat;
    }

    public Object(int img, String name, String kyhan, String hinhthuc, double laixuat) {
        this.img = img;
        this.name = name;
        this.kyhan = kyhan;
        this.hinhthuc = hinhthuc;
        this.laixuat = laixuat;
    }
}
