package com.example.sebastien.myapplication6.model;

/**
 * Created by Sebastien on 11/06/2016.
 */
public class ListItem {
    private final Long id;
    private String text;

    public ListItem(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
