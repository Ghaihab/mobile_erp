package com.example.os;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.os.Clients.RetrofitClientInstance;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestNewCustodyActivity extends AppCompatActivity{

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_new_custody);


        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        Button apply = findViewById(R.id.button_apply);
        renderCustodyButtons();
        apply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                checkButton(view);
            }
        });


    }


    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        createCustodyRequest(radioId);
        Toast.makeText(this, "Requested for: " + radioButton.getText() +" successfully", Toast.LENGTH_SHORT).show();
    }

    private void renderCustodyButtons(){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<com.example.os.DTOs.Custody>> call = service.getCustodyLookup();
        call.enqueue(new Callback<List<com.example.os.DTOs.Custody>>() {
            @Override
            public void onResponse(Call<List<com.example.os.DTOs.Custody>> call, Response<List<com.example.os.DTOs.Custody>> response) {
                for (com.example.os.DTOs.Custody custody : response.body()) {
                    createRadioButton(custody.getName(), custody.getId());
                }
            }

            @Override
            public void onFailure(Call<List<com.example.os.DTOs.Custody>> call, Throwable t) {

            }

        });
    }

    private void createCustodyRequest(int id){

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call <ResponseBody> call = service.createCustodyRequest(id, getAuth());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                redirectToMyCustodyPage();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



    private void createRadioButton(String text, int id){

        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(text);
        radioButton.setId(id);
        radioGroup.addView(radioButton);

    }

    public void redirectToMyCustodyPage(){

        Intent myIntent = new Intent(this, custodyActivity.class);
        startActivity(myIntent);
    }

    private String getAuth(){

        MyDBHandler db = new MyDBHandler(this, null, null, 1);
        return "Bearer " + db.getLastToken();
    }
}
