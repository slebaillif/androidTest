package com.example.sebastien.myapplication6.model;

import java.io.Serializable;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class Category implements Serializable{
    public static String NO_CATEGORY="NO_CAT89*8";
    private String name;
    private String icon;
    private String position;

    public Category(String name, String icon, String position) {
        this.name = name;
        this.icon = icon;
        this.position = position;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
