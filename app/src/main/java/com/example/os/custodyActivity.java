package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class custodyActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.custody);

    }

    public void req_Custody_Button(View view) {
    }


    public void My_Custody_Button(View view) {

        Intent myIntent = new Intent(this, myCustodyActivity.class);
        startActivity(myIntent);

    }
}
