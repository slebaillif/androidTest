package com.example.sebastien.myapplication6.controller;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sebastien.myapplication6.CreateCategoryActivity;
import com.example.sebastien.myapplication6.MainActivity;
import com.example.sebastien.myapplication6.R;
import com.example.sebastien.myapplication6.ToDoListActivity;
import com.example.sebastien.myapplication6.model.Category;
import com.example.sebastien.myapplication6.model.ToDoListApp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class CategoryScreenController {
    public static final int CREATE_CATEGORY = 21;
    private final ToDoListApp appModel;
    private final MainActivity activity;
    private int currentScreenIndex = 0;


    public CategoryScreenController(final ToDoListApp app, final MainActivity activity) {
        this.appModel = app;
        this.activity = activity;
        this.updateCurrentView();
    }

    public void updateCurrentView(){
        updateViewFrom(appModel.getCategoriesByScreen().get(currentScreenIndex));
    }
    private void updateViewFrom(List<Category> categories) {
        for (int i = 0; i < categories.size(); i++) {
            final Category category = categories.get(i);
            int butonId = activity.getResources().getIdentifier("@id/"+ category.getPosition(), null, activity.getPackageName());
            int labelId = activity.getResources().getIdentifier("@id/"+ category.getPosition()+"_name", null, activity.getPackageName());
            ImageButton imageButton = (ImageButton) activity.findViewById(butonId);
            TextView label = (TextView) activity.findViewById(labelId);
            label.setText(categories.get(i).getName());
            setIconFor(category, imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (category.getName().equals(Category.NO_CATEGORY)){
                        Intent createCategory = new Intent(v.getContext(), CreateCategoryActivity.class);
                        createCategory.putExtra("toDoListApp", (Serializable) appModel);
                        createCategory.putExtra("position", category.getPosition());
                        createCategory.putExtra("screenIndex",currentScreenIndex);
                        activity.startActivityForResult(createCategory, CREATE_CATEGORY);
                    }else{
                        Intent viewTodoListForCategory = new Intent(v.getContext(), ToDoListActivity.class);
                        activity.startActivity(viewTodoListForCategory);
                    }
                }
            });
        }
    }


    private void setIconFor(Category category, ImageButton button) {
        if (category != null) {
            int imageResource = activity.getResources().getIdentifier("@drawable/" + category.getIcon(), null, activity.getPackageName());
            button.setImageResource(imageResource);
        }
    }
}
