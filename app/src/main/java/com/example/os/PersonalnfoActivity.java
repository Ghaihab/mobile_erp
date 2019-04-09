package com.example.os;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.os.DTOs.User;

public class PersonalnfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);
        TableLayout personal_information_table = findViewById(R.id.personal_information_table);
        TableRow tableRow = new TableRow(this);
        TextView name = new TextView(this);
        TextView phone_number = new TextView(this);
        TextView ssn = new TextView(this);

        User user = MyDBHandler.getInstance(this).getAuthUser();

        name.setText(user.getName());
        phone_number.setText(user.getPhoneNumber());
        ssn.setText(user.getSSN());

        tableRow.addView(name);
        tableRow.addView(phone_number);
        tableRow.addView(ssn);

        name.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        phone_number.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        ssn.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        personal_information_table.addView(tableRow);


    }



}
