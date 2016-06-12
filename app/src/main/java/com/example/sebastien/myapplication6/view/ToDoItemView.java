package com.example.sebastien.myapplication6.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sebastien.myapplication6.R;
import com.example.sebastien.myapplication6.model.ToDoListItem;

/**
 * Created by Sebastien on 11/06/2016.
 */
public class ToDoItemView extends LinearLayout {

    private final ToDoListItem item;
    private final View inflatedLayout;

    public ToDoItemView(Context context, ToDoListItem item) {
        super(context);
        this.item = item;

        LayoutInflater inflater = LayoutInflater.from(context);
        inflatedLayout = inflater.inflate(R.layout.todo_view, this);
        CheckBox check = (CheckBox) inflatedLayout.findViewById(R.id.to_do_check);
        check.setActivated(item.getDone());
        EditText textView = (EditText) inflatedLayout.findViewById(R.id.to_do_text);
        textView.setText(item.getText());

        check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxClicked(v);
            }
        });
    }

    private void checkBoxClicked(View v) {
        EditText textView = (EditText) inflatedLayout.findViewById(R.id.to_do_text);
        if (item.getDone()){
            item.setDone(false);
        textView.setPaintFlags(textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }else{
            item.setDone(true);
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    private TextView createTextView(ToDoListItem item, Context context) {
        TextView o = new TextView(context);
        o.setText(item.getText());
        o.setVisibility(View.VISIBLE);
        return o;
    }

}
