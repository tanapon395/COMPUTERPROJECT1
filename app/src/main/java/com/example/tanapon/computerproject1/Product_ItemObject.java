package com.example.tanapon.computerproject1;


public class Product_ItemObject {

    private String title;
    private String description;
    private int OptionDigit;


    public Product_ItemObject(String title, String description, int OptionDigit) {
        this.title = title;
        this.description = description;
        this.OptionDigit = OptionDigit;

    }

    public int getOptionDigit() {
        return OptionDigit;
    }

    public void setOptionDigit(int OptionDigit) {
        this.OptionDigit = OptionDigit;
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
