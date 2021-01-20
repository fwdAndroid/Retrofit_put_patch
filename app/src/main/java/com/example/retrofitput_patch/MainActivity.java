package com.example.retrofitput_patch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnPost;
    EditText edtText2;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        btnPost = findViewById(R.id.btnPost);
        edtText2 = findViewById(R.id.edtText2);


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDatausingput();
            }
        });

    }

    private void updateDatausingput() {
        String postBody = edtText2.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apis putModalApis = retrofit.create(apis.class);
        //Mock Data to test
        PutModal putModal = new PutModal("post","Data Patched Successfully");
        //for Put Data
     //   Call<PutModal> call = putModalApis.userUpdaete(putModal);
        Call<PutModal> call = putModalApis.userDataPatch(putModal);
        call.enqueue(new Callback<PutModal>() {
            @Override
            public void onResponse(Call<PutModal> call, Response<PutModal> response) {
                txtView.setText(response.body().getJson().getData());
                Toast.makeText(MainActivity.this, "Code:"+response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PutModal> call, Throwable t) {

            }
        });

    }
}