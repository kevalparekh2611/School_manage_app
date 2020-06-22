package com.example.scm;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class Product {
    private int imageId;
    private String title;


    public Product(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
