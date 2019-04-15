package com.example.os;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.DTOs.CertificationRequest;
import com.example.os.DTOs.CustodyRequest;
import com.example.os.DTOs.User;
import com.example.os.DTOs.VacationRequest;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRequestsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.employees_requests);
        renderCertificationRequests();
        renderCustodyRequests();
        renderVacationRequests();

    }


    public void addTextViewToCertificationRequests(String name, String status, Integer request_id){
        TableLayout employeeCertificationRequests = findViewById(R.id.employeeCertificationRequests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(status);
        tableRow.addView(textView1);
        tableRow.addView(textView2);
        certificationRequestsAddActionButtons(tableRow, request_id);
        employeeCertificationRequests.addView(tableRow);
    }

    private void addTextViewToCustodyRequests(String name, String status, Integer request_id){

        TableLayout employeeCustodyRequests = findViewById(R.id.employeeCustodyRequests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(status);
        tableRow.addView(textView1);
        tableRow.addView(textView2);
        custodyRequestsAddActionButtons(tableRow, request_id);
        employeeCustodyRequests.addView(tableRow);
    }

    private void addTextViewToVacationRequests(String name, String status,String days, Integer request_id){
        TableLayout employeeVacationRequests = findViewById(R.id.employeeVacationRequests);

        TableRow tableRow = new TableRow(this);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        TextView textView3 = new TextView(this);

        textView1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        textView3.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));

        textView1.setText(name);
        textView2.setText(days);
        textView3.setText(status);
        tableRow.addView(textView1);
        tableRow.addView(textView2);
        tableRow.addView(textView3);
        vacationRequestsAddActionButtons(tableRow, request_id);
        employeeVacationRequests.addView(tableRow);
    }

    private void certificationRequestsAddActionButtons(TableRow tableRow, final Integer request_id){

        Button accept = new Button(this);
        Button reject = new Button(this);
        accept.setText("Accept");

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call =  acceptCertificationRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Accepted");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        reject.setText("Reject");

        reject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Call <ResponseBody> call = rejectCertificationRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Rejected");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        tableRow.addView(accept);
        tableRow.addView(reject);
    }



    private void custodyRequestsAddActionButtons(TableRow tableRow, final Integer request_id){

        Button accept = new Button(this);
        Button reject = new Button(this);
        accept.setText("Accept");

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call =  acceptCustodyRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Accepted");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        reject.setText("Reject");

        reject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Call <ResponseBody> call = rejectCustodyRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Rejected");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        tableRow.addView(accept);
        tableRow.addView(reject);
    }

    private void vacationRequestsAddActionButtons(TableRow tableRow, final Integer request_id) {

        Button accept = new Button(this);
        Button reject = new Button(this);
        accept.setText("Accept");

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call =  acceptVacationRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Accepted");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        reject.setText("Reject");

        reject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Call <ResponseBody> call = rejectVacationRequest(request_id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        showSuccessMessage("Rejected");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        tableRow.addView(accept);
        tableRow.addView(reject);
    }

    private void renderCertificationRequests(){
        Call<List<CertificationRequest>> call = getCertificationRequests();
        call.enqueue(new Callback<List<CertificationRequest>>() {
            @Override
            public void onResponse(Call<List<CertificationRequest>> call, Response<List<CertificationRequest>> response) {
                for (CertificationRequest certificationRequest : response.body()){
                    addTextViewToCertificationRequests(
                            certificationRequest.getCourse_name(), certificationRequest.getStatus(), certificationRequest.getId()
                    );
                }
            }

            @Override
            public void onFailure(Call<List<CertificationRequest>> call, Throwable t) {

            }
        });
    }

    private void renderCustodyRequests(){

        Call<List<CustodyRequest>> call = getCustodyRequests();
        call.enqueue(new Callback<List<CustodyRequest>>() {
            @Override
            public void onResponse(Call<List<CustodyRequest>> call, Response<List<CustodyRequest>> response) {
                for (CustodyRequest custodyRequest : response.body()) {
                    addTextViewToCustodyRequests(custodyRequest.getCustody().getName(), custodyRequest.getStatus(), custodyRequest.getId());
                }
            }

            @Override
            public void onFailure(Call<List<CustodyRequest>> call, Throwable t) {

            }
        });
    }

    private void renderVacationRequests() {
        Call<List<VacationRequest>> call = getVacationRequests();
        call.enqueue(new Callback<List<VacationRequest>>() {
            @Override
            public void onResponse(Call<List<VacationRequest>> call, Response<List<VacationRequest>> response) {
                for (VacationRequest vacationRequest : response.body()){
                    addTextViewToVacationRequests(
                            vacationRequest.getVacation().getName(),
                            vacationRequest.getStatus(),
                            vacationRequest.getNumberOfDays(),
                            vacationRequest.getId()
                    );
                }
            }

            @Override
            public void onFailure(Call<List<VacationRequest>> call, Throwable t) {

            }
        });
    }

    private Call<List<CertificationRequest>> getCertificationRequests(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <List<CertificationRequest>> call = null;
        if(user.isHR()){
            call = service.getCertificationRequestsUnderHr();
        } else if(user.isManager()){
            call = service.getCertificationRequestsUnderManager();
        }

        return call;
    }


    private Call<List<CustodyRequest>> getCustodyRequests() {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <List<CustodyRequest>> call = null;
        if(user.isHR()){
            call = service.getCustodyRequestsUnderHr();
        } else if(user.isManager()){
            call = service.getCustodyRequestsUnderManager();
        }

        return call;
    }

    private Call<List<VacationRequest>> getVacationRequests(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <List<VacationRequest>> call = null;
        if(user.isHR()){
            call = service.getVacationRequestsUnderHr();
        } else if(user.isManager()){
            call = service.getVacationRequestsUnderManager();
        }

        return call;
    }

    private Call<ResponseBody> acceptCertificationRequest(Integer request_id){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <ResponseBody> call = null;
        if(user.isHR()){
            call = service.hrAcceptCertificationRequest(request_id);
        } else if(user.isManager()){
            call = service.managerAcceptCertificationRequest(request_id);
        }

        return call;
    }

    private Call<ResponseBody> rejectCertificationRequest(Integer request_id) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        return service.rejectCertificationRequest(request_id);
    }


    private Call<ResponseBody> acceptCustodyRequest(Integer request_id){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <ResponseBody> call = null;
        if(user.isHR()){
            call = service.hrAcceptCustodyRequest(request_id);
        } else if(user.isManager()){
            call = service.managerAcceptCustodyRequest(request_id);
        }

        return call;
    }

    private Call<ResponseBody> rejectCustodyRequest(Integer request_id) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        return service.rejectCustodyRequest(request_id);
    }


    private Call<ResponseBody> acceptVacationRequest(Integer request_id) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        User user = MyDBHandler.getInstance(this).getAuthUser();
        Call <ResponseBody> call = null;
        if(user.isHR()){
            call = service.hrAcceptVacationRequest(request_id);
        } else if(user.isManager()){
            call = service.managerAcceptVacationRequest(request_id);
        }

        return call;
    }

    private Call<ResponseBody> rejectVacationRequest(Integer request_id) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        return service.rejectVacationRequest(request_id);

    }

    private void showSuccessMessage(String action) {
        Toast.makeText(this, action+ " successfully", Toast.LENGTH_SHORT).show();
    }


}
