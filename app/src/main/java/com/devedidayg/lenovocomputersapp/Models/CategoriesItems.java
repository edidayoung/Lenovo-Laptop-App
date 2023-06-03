package com.devedidayg.lenovocomputersapp.Models;

public class CategoriesItems {
    String names;
    int images;
    String details;
    String desc;

    public CategoriesItems(String names, int images,String details, String desc) {
        this.names = names;
        this.images = images;
        this.details = details;
        this.desc = desc;

    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
