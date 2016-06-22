package com.example.sebastien.myapplication6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class ToDoListApp implements Serializable{
    List<List<Category>> categoriesByScreen;

    public ToDoListApp() {
        categoriesByScreen = new ArrayList<>();
        List<Category> firstScreen = new ArrayList<>();
        Category tb = new Category(Category.NO_CATEGORY, "dash", "top_button");
        Category second_left_button = new Category(Category.NO_CATEGORY, "dash", "second_left_button");
        Category second_right_button = new Category(Category.NO_CATEGORY, "dash", "second_right_button");
        Category third_left_button = new Category(Category.NO_CATEGORY, "dash", "third_left_button");
        Category third_right_button = new Category(Category.NO_CATEGORY, "dash", "third_right_button");
        firstScreen.add(tb);
        firstScreen.add(second_left_button);
        firstScreen.add(second_right_button);
        firstScreen.add(third_left_button);
        firstScreen.add(third_right_button);

        categoriesByScreen.add(firstScreen);
    }

    public List<List<Category>> getCategoriesByScreen() {
        return categoriesByScreen;
    }
}
