package com.example.sebastien.myapplication6.model;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class Category {
    private String name;
    private String icon;
    private String position;

    public Category(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getPosition() {
        return position;
    }
}
