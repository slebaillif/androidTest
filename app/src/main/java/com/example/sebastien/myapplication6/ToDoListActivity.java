package com.example.sebastien.myapplication6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.sebastien.myapplication6.model.ToDoListItem;
import com.example.sebastien.myapplication6.view.ToDoItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastien on 22/06/2016.
 */
public class ToDoListActivity extends AppCompatActivity {
    List<ToDoListItem> todoList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist_screen);
        final LinearLayout todoListLayout = (LinearLayout) findViewById(R.id.to_do_list);
        Button addToDo = (Button) findViewById(R.id.add_to_do);
        addToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDoItem(todoListLayout);
            }
        });
    }

    private void addToDoItem(LinearLayout todoListLayout) {
        EditText text = (EditText) findViewById(R.id.add_to_do_text);
        ToDoListItem item = new ToDoListItem(1L, text.getText().toString());
        todoList.add(item);
        todoListLayout.addView(new ToDoItemView(this, item));
        text.setText("");
    }
}
