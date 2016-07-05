package com.example.sebastien.myapplication6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    boolean expanded = true;
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
        final ImageButton epandButton = (ImageButton) findViewById(R.id.expand_lists_button);
        epandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expanded){
                    LinearLayout layout = (LinearLayout) findViewById(R.id.list_names_layout);
                    LinearLayout listLayout = (LinearLayout) findViewById(R.id.list_layout);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    listLayout.setLayoutParams(params);
                    layout.setVisibility(View.GONE);
                    epandButton.setImageResource(R.drawable.ic_chevron_left_black_24dp);
                    expanded = false;
                    v.invalidate();
                }else{
                    LinearLayout layout = (LinearLayout) findViewById(R.id.list_names_layout);
                    layout.setVisibility(View.VISIBLE);
                    LinearLayout listLayout = (LinearLayout) findViewById(R.id.list_layout);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    listLayout.setLayoutParams(params);
                    epandButton.setImageResource(R.drawable.ic_chevron_right_black_24dp);
                    expanded = true;
                    v.invalidate();
                }
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
