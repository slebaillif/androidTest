package com.example.sebastien.myapplication6.model;

import java.util.Date;

/**
 * Created by Sebastien on 11/06/2016.
 */
public class ToDoListItem extends ListItem{

    private Boolean done = false;
    private Date due = null;

    public ToDoListItem(Long id, String text) {
        super(id, text);
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }
}
