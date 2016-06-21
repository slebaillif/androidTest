package com.example.sebastien.myapplication6.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sebastien on 19/06/2016.
 */
public class ToDoListApp {
    List<List<Category>> categoriesByScreen;

    public ToDoListApp() {
        categoriesByScreen = new ArrayList<>();
        List<Category> firstScreen = new ArrayList<>();
        categoriesByScreen.add(firstScreen);
    }
}
