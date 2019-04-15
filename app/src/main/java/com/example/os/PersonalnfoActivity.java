package com.example.os;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.os.DTOs.User;

import org.w3c.dom.Text;

public class PersonalnfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);
        User user = MyDBHandler.getInstance(this).getAuthUser();

        TextView name = findViewById(R.id.textView4);
        TextView phone_number = findViewById(R.id.textView6);
        TextView email = findViewById(R.id.textView5);
        TextView gender = findViewById(R.id.textView8);
        TextView ssn = findViewById(R.id.textView10);

        name.setText(user.getName());
        phone_number.setText(user.getPhoneNumber());
        email.setText(user.getEmail());
        gender.setText(user.getGender());
        ssn.setText(user.getSSN());

    }



}
