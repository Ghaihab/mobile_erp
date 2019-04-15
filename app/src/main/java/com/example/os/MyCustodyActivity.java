package com.example.os;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.Custody;
import com.example.os.DTOs.CustodyRequest;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCustodyActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_custody);
        renderMyCustodies();
        renderCustodyRequests();

    }

    private void addTextViewToMyCustodies(String name) {

        TableLayout accpetedCustodies = findViewById(R.id.accepted_certification);
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText(name);
        tableRow.addView(textView);
        textView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        accpetedCustodies.addView(tableRow);
    }

    private void addTextViewToCustodyRequests(String name, String status){

        TableLayout custodyRequests = findViewById(R.id.custody_requests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(status);
        tableRow.addView(textView1);
        tableRow.addView(textView2);

        custodyRequests.addView(tableRow);
    }



    private void renderCustodyRequests(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<CustodyRequest>> call = service.getCustodyRequests();
        call.enqueue(new Callback<List<CustodyRequest>>() {
            @Override
            public void onResponse(Call<List<CustodyRequest>> call, Response<List<CustodyRequest>> response) {
                for (CustodyRequest custodyRequest : response.body()) {
                    addTextViewToCustodyRequests(custodyRequest.getCustody().getName(), custodyRequest.getStatus());
                }
            }

            @Override
            public void onFailure(Call<List<CustodyRequest>> call, Throwable t) {

            }
        });
    }

    private void renderMyCustodies(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Custody>> call = service.getCustodies(getAuth());

        call.enqueue(new Callback<List<Custody>>() {
            @Override
            public void onResponse(Call<List<Custody>> call, Response<List<Custody>> response) {
                for (Custody custody : response.body()){
                    addTextViewToMyCustodies(custody.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Custody>> call, Throwable t) {

            }
        });
    }



    private String getAuth(){

        MyDBHandler db = new MyDBHandler(this, null, null, 1);
        return "Bearer " + db.getLastToken();
    }

}
