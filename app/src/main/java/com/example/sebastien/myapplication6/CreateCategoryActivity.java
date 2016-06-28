package com.example.sebastien.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sebastien.myapplication6.controller.CategoryScreenController;
import com.example.sebastien.myapplication6.model.Category;
import com.example.sebastien.myapplication6.model.ToDoListApp;
import com.example.sebastien.myapplication6.model.event.CategoryCreationEvent;

import java.util.List;

/**
 * Created by Sebastien on 22/06/2016.
 */
public class CreateCategoryActivity extends AppCompatActivity {
    private ToDoListApp toDoListApp;
    private String position;
    private Integer screenIndex;
    private String chosenIcon = "dash";


    public CreateCategoryActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_category);
        Bundle extras = getIntent().getExtras();
        toDoListApp = (ToDoListApp) extras.get("toDoListApp");
        position = (String) extras.get("position");
        screenIndex = (int) extras.get("screenIndex");
        //  manage ok/cancel button listener
        Button okButtn = (Button) findViewById(R.id.ok_button);
        Button cancel = (Button) findViewById(R.id.cancel_button);
        final ImageButton ballButtn = (ImageButton) findViewById(R.id.ball_button);
        final ImageButton duckButtn = (ImageButton) findViewById(R.id.duck_button);
        final ImageButton handsButtn = (ImageButton) findViewById(R.id.hands_button);
        final ImageButton skatButtn = (ImageButton) findViewById(R.id.skate_button);
        final ImageButton tshirtButtn = (ImageButton) findViewById(R.id.tshirt_button);
        final ImageButton legoButtn = (ImageButton) findViewById(R.id.lego_button);
        okButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryCreationEvent event = new CategoryCreationEvent(screenIndex,chosenIcon,((EditText) findViewById(R.id.category_name)).getText().toString(), position);
                Intent resultData = new Intent();
                resultData.putExtra("newCategoryEvent", event);
                setResult(RESULT_OK, resultData);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        ballButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(getDrawable(R.drawable.borders));
                duckButtn.setBackground(null);
                handsButtn.setBackground(null);
                skatButtn.setBackground(null);
                legoButtn.setBackground(null);
                tshirtButtn.setBackground(null);
                chosenIcon = "ball";
            }
        });
        duckButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(null);
                duckButtn.setBackground(getDrawable(R.drawable.borders));
                handsButtn.setBackground(null);
                skatButtn.setBackground(null);
                legoButtn.setBackground(null);
                tshirtButtn.setBackground(null);
                chosenIcon = "duck";
            }
        });
        handsButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(null);
                duckButtn.setBackground(null);
                handsButtn.setBackground(getDrawable(R.drawable.borders));
                skatButtn.setBackground(null);
                legoButtn.setBackground(null);
                tshirtButtn.setBackground(null);
                chosenIcon = "hands";
            }
        });
        legoButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(null);
                duckButtn.setBackground(null);
                handsButtn.setBackground(null);
                skatButtn.setBackground(null);
                legoButtn.setBackground(getDrawable(R.drawable.borders));
                tshirtButtn.setBackground(null);
                chosenIcon = "lego";
            }
        });
        skatButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(null);
                duckButtn.setBackground(null);
                handsButtn.setBackground(null);
                skatButtn.setBackground(getDrawable(R.drawable.borders));
                legoButtn.setBackground(null);
                tshirtButtn.setBackground(null);
                chosenIcon = "skate";
            }
        });
        tshirtButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballButtn.setBackground(null);
                duckButtn.setBackground(null);
                handsButtn.setBackground(null);
                skatButtn.setBackground(null);
                legoButtn.setBackground(null);
                tshirtButtn.setBackground(getDrawable(R.drawable.borders));
                chosenIcon = "tshirt";
            }
        });
    }


}
