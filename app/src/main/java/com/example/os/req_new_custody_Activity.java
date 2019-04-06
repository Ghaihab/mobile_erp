package com.example.os;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class req_new_custody_Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_new_custody);

        TableLayout accpeted_custodies = findViewById(R.id.accepted_custodies);
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText("weclome");
        tableRow.addView(textView);
        accpeted_custodies.addView(tableRow);


    }







}
