package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.os.DTOs.User;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        User user = MyDBHandler.getInstance(this).getAuthUser();

        if(user.isRegularEmployee()){
            Button buttonEmployeeRequests = findViewById(R.id.buttonEmployeeRequests);
            buttonEmployeeRequests.setVisibility(View.GONE);
        }

    }

    public void buttonPersonalnformation(View view) {

        Intent myIntent = new Intent(this, PersonalnfoActivity.class);
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

    public void buttonEmployeeRequests(View view){
        startActivity(new Intent(this, EmployeeRequestsActivity.class));
    }

    public void buttonCertification(View view){
        startActivity(new Intent(this, CertificationActivity.class));
    }

}
