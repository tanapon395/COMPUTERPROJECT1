package com.example.tanapon.computerproject1;

/**
 * Created by NgocTri on 11/5/2016.
 */

public class RecyclerItem_Product {

    private String title;
    private String description;

    public RecyclerItem_Product(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
