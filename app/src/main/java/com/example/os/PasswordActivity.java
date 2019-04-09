package com.example.os;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.Interfaces.GetDataService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validatePassword();
            }
        });


    }

    public void validatePassword(){
        EditText password = findViewById(R.id.password);
        EditText confirm_password = findViewById(R.id.confirm_password);

        if(password.getText().toString().equals(confirm_password.getText().toString())){
         changePassword(password.getText().toString());
        }else {
            Toast.makeText(this, "Passwords are not matched! ", Toast.LENGTH_SHORT).show();
        }

    }

    public void changePassword(String newPassword){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = service.changePassword(newPassword, MyDBHandler.getInstance(this).getAuthToken());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                redirectToMainPage();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    public void redirectToMainPage(){
        Toast.makeText(this, "Password changed successfully! ", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, ActivityMain.class);
        startActivity(myIntent);
    }
}
