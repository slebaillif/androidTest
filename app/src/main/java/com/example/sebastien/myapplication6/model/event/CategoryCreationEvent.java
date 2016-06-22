package com.example.sebastien.myapplication6.model.event;

import java.io.Serializable;

/**
 * Created by Sebastien on 22/06/2016.
 */
public class CategoryCreationEvent implements Serializable{
    Integer screenIndex;
    String icon;
    String name;
    String position;

    public CategoryCreationEvent(Integer screenIndex, String icon, String name, String position) {
        this.screenIndex = screenIndex;
        this.icon = icon;
        this.name = name;
        this.position = position;
    }

    public Integer getScreenIndex() {
        return screenIndex;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
