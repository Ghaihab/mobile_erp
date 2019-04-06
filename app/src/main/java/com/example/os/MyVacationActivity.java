package com.example.os;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MyVacationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_vacation);

        TableLayout accpeted_custodies = findViewById(R.id.accepted_custodies);
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText("weclome");
        tableRow.addView(textView);
        accpeted_custodies.addView(tableRow);

        TableLayout custody_requests = findViewById(R.id.vacation_requests);
        TableRow tableRow1 = new TableRow(this);
        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        textView1.setText("house");
        textView2.setText("rejected");
        tableRow1.addView(textView1);
        tableRow1.addView(textView2);
        custody_requests.addView(tableRow1);



    }
}

