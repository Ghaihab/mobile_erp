package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.Login;
import com.example.os.Interfaces.GetDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }

    public void addHandlers(String newToken) throws Exception {

        MyDBHandler dbh = new MyDBHandler(this, null, null, 1);
        dbh.addToken(newToken);
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
        dbh.close();

    }

    public void deleteAll() {

        MyDBHandler dbh = new MyDBHandler(this, null, null, 1);
        dbh.deleteTokens();
        dbh.close();

    }

    public void LoginButton(View view) {

        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Login> call = service.login(username, password);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Login login = response.body();
                try {
                    deleteAll();
                    String newToken = login.getAccessToken();
                    addHandlers(newToken);
                    redirectToMainPage();

                } catch (Exception exception){
                    showErrorLoginMessage();
                }


            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                showErrorLoginMessage();
            }
        });


    }

    public void redirectToMainPage(){

        Intent myIntent = new Intent(this, ActivityMain.class);
        startActivity(myIntent);
    }

    public void showErrorLoginMessage(){
        Toast.makeText(this, "Logging failed, check inputs!", Toast.LENGTH_SHORT).show();
    }

}
