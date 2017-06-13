package com.example.tanapon.computerproject1;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Home_Album {
    private String name;
    private int thumbnail;

    public Home_Album() {
    }

    public Home_Album(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
