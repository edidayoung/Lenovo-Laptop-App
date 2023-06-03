package com.devedidayg.lenovocomputersapp.Models;

import java.io.Serializable;

public class ItemsModel implements Serializable {
    private String name;
    private int images;
    private String desc;



    public ItemsModel(String name, int images, String desc) {
        this.name = name;
        this.images = images;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


