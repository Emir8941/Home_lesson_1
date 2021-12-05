package com.example.home_work_1.model;

import java.io.Serializable;

public class BookModel implements Serializable {

    private String name;
    private String Description;
    private int image;

    public BookModel(String name, String description, int image) {
        this.name = name;
        Description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
