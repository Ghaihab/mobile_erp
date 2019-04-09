package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void buttonPersonalnformation(View view) {

        Intent myIntent = new Intent(this, PersonalnfoActivity.class);
       // Employee emp = (Employee)getIntent().getParcelableExtra("emp");
      //  myIntent.putExtra("employee", emp);
        startActivity(myIntent);

    }

    public void buttonMainCustody(View view) {

        Intent myIntent = new Intent(this, custodyActivity.class);
        startActivity(myIntent);

    }

    public void buttonVacation(View view){
        startActivity(new Intent(this, VacationActivity.class));
    }

    public void buttonChangePassword(View view){
        startActivity(new Intent(this, PasswordActivity.class));
    }

}
