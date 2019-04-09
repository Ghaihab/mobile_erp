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
import com.example.os.DTOs.Custody;
import com.example.os.DTOs.Vacation;
import com.example.os.Interfaces.GetDataService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestNewVacationActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_new_vacation);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        Button apply = findViewById(R.id.button_apply);
        renderCustodyButtons();
        apply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                checkButton(view);
            }
        });


    }


    public void checkButton(View view) {

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        createVacationRequest(radioId);
        Toast.makeText(this, "Requested for: " + radioButton.getText() + " successfully", Toast.LENGTH_SHORT).show();


    }


    private void createRadioButton(String text, int id) {

        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(text);
        radioButton.setId(id);
        radioGroup.addView(radioButton);

    }


    private void renderCustodyButtons() {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Vacation>> call = service.getVacationLookup();
        call.enqueue(new Callback<List<Vacation>>() {
            @Override
            public void onResponse(Call<List<Vacation>> call, Response<List<Vacation>> response) {
                for (Vacation vacation : response.body()) {
                    createRadioButton(vacation.getName(), vacation.getId());
                }
            }

            @Override
            public void onFailure(Call<List<Vacation>> call, Throwable t) {

            }
        });
    }

    private void createVacationRequest(int id) {

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = service.createVacationRequest(id, getAuth());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                redirectToMyVacationPage();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    public void redirectToMyVacationPage() {

        Intent myIntent = new Intent(this, VacationActivity.class);
        startActivity(myIntent);
    }

    private String getAuth() {

        MyDBHandler db = new MyDBHandler(this, null, null, 1);
        return "Bearer " + db.getLastToken();
    }
}
