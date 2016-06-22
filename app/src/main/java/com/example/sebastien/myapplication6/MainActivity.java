package com.example.sebastien.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.sebastien.myapplication6.controller.CategoryScreenController;
import com.example.sebastien.myapplication6.model.Category;
import com.example.sebastien.myapplication6.model.ToDoListApp;
import com.example.sebastien.myapplication6.model.ToDoListItem;
import com.example.sebastien.myapplication6.model.event.CategoryCreationEvent;
import com.example.sebastien.myapplication6.view.ToDoItemView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CategoryScreenController categoryScreenController;

    ToDoListApp app = new ToDoListApp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_screen);
        categoryScreenController = new CategoryScreenController(app, this);

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CategoryScreenController.CREATE_CATEGORY) {
            if (resultCode == RESULT_OK) {
                CategoryCreationEvent event = (CategoryCreationEvent) data.getExtras().get("newCategoryEvent");
                confirmCategoryCreation(event);
                categoryScreenController.updateCurrentView();
            }
        }
    }

    private void confirmCategoryCreation(CategoryCreationEvent event) {
        List<Category> l = app.getCategoriesByScreen().get(event.getScreenIndex());
        for (Category category : l) {
            if (category.getPosition().equals(event.getPosition())) {
                category.setIcon(event.getIcon());
                category.setName(event.getName());
            }
        }
    }
}
