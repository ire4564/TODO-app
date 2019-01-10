package com.example.home.my_calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
일정 변경
리스트뷰 클릭 이벤트
subitem??
 */
public class MainView extends AppCompatActivity {
    private ListView TaskView;
    private EditText MainTaskAddEdit;
    private ImageView MainTaskAddBtn;

    ArrayList<String> My_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        TaskView = (ListView) findViewById(R.id.TaskView);
        MainTaskAddEdit = (EditText) findViewById(R.id.MainTaskAddEdit);
        MainTaskAddBtn = (ImageView) findViewById(R.id.MainTaskAddBtn);

        //adapt MyList to TaskView
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, My_List);
        TaskView.setAdapter(adapter);
        My_List.add("hello");
        My_List.add("bye");
        //MainTaskAddBtn onClick
        MainTaskAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = MainTaskAddEdit.getText().toString();
                adapter.add(task);
                MainTaskAddEdit.setText("");
                Toast.makeText(getApplicationContext(), "task added", Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, message, duration);
            }
        });


    }
}