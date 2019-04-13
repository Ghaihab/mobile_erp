package com.example.os;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.Vacation;
import com.example.os.DTOs.VacationRequest;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyVacationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_vacation);
        renderMyVacations();
        renderVacationRequests();

    }

    private void addTextViewToMyVacations(String name) {

        TableLayout accepted_vacations = findViewById(R.id.accepted_vacations);
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText(name);
        tableRow.addView(textView);
        textView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        accepted_vacations.addView(tableRow);
    }

    private void addTextViewToVacationRequests(String name, String status){

        TableLayout vacation_requests = findViewById(R.id.vacation_requests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(status);
        tableRow.addView(textView1);
        tableRow.addView(textView2);
        vacation_requests.addView(tableRow);
    }

    private void renderVacationRequests(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<VacationRequest>> call = service.getVacationRequests();
        call.enqueue(new Callback<List<VacationRequest>>() {
            @Override
            public void onResponse(Call<List<VacationRequest>> call, Response<List<VacationRequest>> response) {
                for(VacationRequest vacationRequest : response.body()){
                    addTextViewToVacationRequests(vacationRequest.getVacation().getName(), vacationRequest.getStatus());
                }
            }

            @Override
            public void onFailure(Call<List<VacationRequest>> call, Throwable t) {

            }
        });
    }

    private void renderMyVacations(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Vacation>> call = service.getVacations(MyDBHandler.getInstance(this).getAuthToken());

        call.enqueue(new Callback<List<Vacation>>() {
            @Override
            public void onResponse(Call<List<Vacation>> call, Response<List<Vacation>> response) {
                for (Vacation vacation : response.body()){
                    addTextViewToMyVacations(vacation.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Vacation>> call, Throwable t) {

            }
        });
    }
}

