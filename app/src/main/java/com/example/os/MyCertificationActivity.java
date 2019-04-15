package com.example.os;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.CertificationRequest;
import com.example.os.DTOs.Custody;
import com.example.os.DTOs.CustodyRequest;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCertificationActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_certification);
        renderMyCertification();
        renderCertificationRequests();
    }


    private void addTextViewToMyCertification(String name) {

        TableLayout accepted_certification = findViewById(R.id.accepted_certification);
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText(name);
        tableRow.addView(textView);
        textView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        accepted_certification.addView(tableRow);
    }

    private void addTextViewToCertificationRequests(String name, String training_place, String from, String to, String status){

        TableLayout certification_requests = findViewById(R.id.certification_requests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        TextView textView3 = new TextView(this);
        TextView textView4 = new TextView(this);
        TextView textView5 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView3.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView4.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView5.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(training_place);
        textView3.setText(from);
        textView4.setText(to);
        textView5.setText(status);

        tableRow.addView(textView1);
        tableRow.addView(textView2);
        tableRow.addView(textView3);
        tableRow.addView(textView4);
        tableRow.addView(textView5);

        certification_requests.addView(tableRow);
    }



    private void renderCertificationRequests(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<CertificationRequest>> call = service.getCertificationRequests();
        call.enqueue(new Callback<List<CertificationRequest>>() {
            @Override
            public void onResponse(Call<List<CertificationRequest>> call, Response<List<CertificationRequest>> response) {
                for (CertificationRequest certificationRequest : response.body()){
                    addTextViewToCertificationRequests(
                            certificationRequest.getCourse_name(),
                            certificationRequest.getTraining_place(),
                            certificationRequest.getFrom(),
                            certificationRequest.getTo(),
                            certificationRequest.getStatus()
                    );
                }
            }

            @Override
            public void onFailure(Call<List<CertificationRequest>> call, Throwable t) {

            }
        });
    }

    private void renderMyCertification(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<CertificationRequest>> call = service.getUploads(MyDBHandler.getInstance(this).getAuthToken());

        call.enqueue(new Callback<List<CertificationRequest>>() {
            @Override
            public void onResponse(Call<List<CertificationRequest>> call, Response<List<CertificationRequest>> response) {
                for (CertificationRequest certificationRequest : response.body()){
                    addTextViewToMyCertification(certificationRequest.getCourse_name());
                }
            }

            @Override
            public void onFailure(Call<List<CertificationRequest>> call, Throwable t) {

            }
        });
    }
}
