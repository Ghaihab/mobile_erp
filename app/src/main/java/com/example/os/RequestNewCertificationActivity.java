package com.example.os;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.Login;
import com.example.os.Interfaces.GetDataService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestNewCertificationActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_new_certification);

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendCertification();
            }
        });

    }

    private void sendCertification() {
        EditText course_name = findViewById(R.id.course_name);
        EditText training_place = findViewById(R.id.training_place);
        EditText expected_hours= findViewById(R.id.expected_hours);
        EditText date_from = findViewById(R.id.req_date_from);
        EditText date_to = findViewById(R.id.req_date_to);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = service.createCertificationRequest(
                MyDBHandler.getInstance(this).getAuthToken(),
                course_name.getText().toString(),
                training_place.getText().toString(),
                expected_hours.getText().toString(),
                date_from.getText().toString(),
                date_to.getText().toString()
        );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                showSuccessMessage();
                redirectToCertificationPage();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void redirectToCertificationPage(){

        Intent myIntent = new Intent(this, CertificationActivity.class);
        startActivity(myIntent);
    }

    public void showSuccessMessage(){
        Toast.makeText(this, "Requested Successfully !", Toast.LENGTH_SHORT).show();
    }


}
