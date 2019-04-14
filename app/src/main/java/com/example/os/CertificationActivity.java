package com.example.os;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CertificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.certification);

    }

    public void my_certification_Button(View view){
        startActivity(new Intent(this, MyCertificationActivity.class));
    }

    public void req_certification_Button(View view){
        startActivity(new Intent(this, RequestNewCertificationActivity.class));
    }

}
