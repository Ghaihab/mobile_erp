package com.example.os;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class VacationActivity  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacation);

    }

    public void req_vacation_Button(View view) {
        Intent myIntent = new Intent(this, RequestNewVacationActivity.class);
        startActivity(myIntent);
    }


    public void My_vacation_Button(View view) {

        Intent myIntent = new Intent(this, MyVacationActivity.class);
        startActivity(myIntent);

    }
}

}
