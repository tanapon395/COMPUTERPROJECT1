package com.example.tanapon.computerproject1;


public class Bill_ItemObject {

    private String title;
    private String description;
    private String sum_menu;

    public Bill_ItemObject(String title,String sum_menu, String description) {
        this.title = title;
        this.description = description;
        this.sum_menu = sum_menu;
    }

    public String getTitle_Bill() {
        return title;
    }

    public void setTitle_Bill(String title) {

        this.title = title;
    }

    public String getDescription_Bill() {
        return description;
    }

    public void setDescription_Bill(String description) {

        this.description = description;
    }
    public String getSum_menu_Bill() {
        return sum_menu;
    }

    public void setSum_menu(String sum_menu) {

        this.sum_menu = sum_menu;
    }

}
