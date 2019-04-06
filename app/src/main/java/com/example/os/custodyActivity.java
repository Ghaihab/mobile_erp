package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class custodyActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.custody);

    }

    public void req_Custody_Button(View view) {
        Intent myIntent = new Intent(this, RequestNewCustodyActivity.class);
        startActivity(myIntent);
    }


    public void My_Custody_Button(View view) {

        Intent myIntent = new Intent(this, MyCustodyActivity.class);
        startActivity(myIntent);

    }
}
