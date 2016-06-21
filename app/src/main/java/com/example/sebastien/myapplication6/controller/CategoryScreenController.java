package com.example.sebastien.myapplication6.controller;

import android.widget.ImageButton;

import com.example.sebastien.myapplication6.MainActivity;
import com.example.sebastien.myapplication6.R;
import com.example.sebastien.myapplication6.model.Category;
import com.example.sebastien.myapplication6.model.ToDoListApp;

import java.util.List;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class CategoryScreenController {
    private final ToDoListApp appModel;
    private final MainActivity activity;
    private int currentScreenIndex = 0;


    public CategoryScreenController(ToDoListApp app, MainActivity activity) {
        this.appModel = app;
        this.activity = activity;
    }

    private void updateViewFrom(List<Category> categories) {
        for (int i = 0; i < categories.size(); i++) {
            ImageButton imagButton;
            int id = activity.getResources().getIdentifier("id/"+categories.get(i).getPosition(), null, activity.getPackageName());
            imagButton = (ImageButton) activity.findViewById(id);
            setIconFor(categories.get(i), imagButton);
        }
    }

    private void setIconFor(Category category, ImageButton button) {
        if (category != null) {
            int imageResource = activity.getResources().getIdentifier("drawable/" + category.getIcon(), null, activity.getPackageName());
            button.setImageResource(imageResource);
        }
    }
}
