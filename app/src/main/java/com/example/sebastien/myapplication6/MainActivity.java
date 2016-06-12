package com.example.sebastien.myapplication6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sebastien.myapplication6.model.ToDoListItem;
import com.example.sebastien.myapplication6.view.ToDoItemView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ToDoListItem> todoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
