package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.RetroPhoto;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }

    public void addHandlers(View view) throws Exception {

//        MyDBHandler dbh = new MyDBHandler(this, null, null, 1);
//
//        Employee emp1 = new Employee();
//
//        emp1.setUsername("osama1");
//        emp1.setPassword("os1");
//        emp1.setFirst_name("Osama");
//        emp1.setLast_name("Alqahtani");
//        emp1.setPhone_number("0502424171");
//        emp1.setSsn("433101193");
//
//        Employee emp2 = new Employee();
//
//        emp2.setUsername("osama2");
//        emp2.setPassword("os2");
//        emp2.setFirst_name("Osama");
//        emp2.setLast_name("Alqahtani");
//        emp2.setPhone_number("0502424121");
//        emp2.setSsn("433101192");
//
//        dbh.addHandlerEmployee(emp1);
//        dbh.addHandlerEmployee(emp2);

        test();


//        Toast.makeText(this, "All Employees were added successfully!!!", Toast.LENGTH_SHORT).show();
//
//        dbh.close();

    }

    public void deleteAll(View view) {

        MyDBHandler dbh = new MyDBHandler(this, null, null, 1);

        dbh.deleteAll();

        Toast.makeText(this, "All Employees were deleted successfully!!!", Toast.LENGTH_SHORT).show();

        dbh.close();

    }

    public void LoginButton(View view) {

        MyDBHandler dbh = new MyDBHandler(this, null, null, 1);

        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        Employee employee = dbh.getUser(username, password);

        if(employee != null) {

            Intent myIntent = new Intent(this, ActivityMain.class);
            myIntent.putExtra("emp", employee);
            startActivity(myIntent);

        } else
            Toast.makeText(this, "Wrong Username of Password !!!", Toast.LENGTH_SHORT).show();

        dbh.close();

    }


    private void test() throws Exception {

        System.out.println("inside");

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                List<RetroPhoto> list = response.body();
                System.out.println("success");
                for(RetroPhoto item : list)
                    System.out.println(item);
                System.out.println(call.getClass());

            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                System.out.println("Error!!");
            }
        });


    }

}
