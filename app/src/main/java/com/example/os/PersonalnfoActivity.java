package com.example.os;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PersonalnfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);

       // setPI();

    }

    private void setPI() {

        TextView emp_name = (TextView)findViewById(R.id.tvName);
        TextView emp_phone_number = (TextView)findViewById(R.id.tvPhoneNumber);
        TextView emp_ssn = (TextView)findViewById(R.id.tvSsn);
        Employee emp = ((Employee)getIntent().getParcelableExtra("employee"));

        emp_name.setText(emp.getFirst_name() + " " + emp.getLast_name());
        emp_phone_number.setText(emp.getPhone_number());
        emp_ssn.setText(emp.getSsn());

    }

}
