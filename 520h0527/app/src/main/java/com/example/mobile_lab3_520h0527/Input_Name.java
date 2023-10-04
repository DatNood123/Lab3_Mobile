package com.example.mobile_lab3_520h0527;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Input_Name extends AppCompatActivity {

    private EditText name;
    private Button btnsave;
    private TextView welcome2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_name);

        this.btnsave = findViewById(R.id.btnsave);
        this.name= findViewById(R.id.name);
        this.welcome2 = findViewById(R.id.hello);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        this.welcome2.setText("Xin chào " + email+ ". Vui lòng nhập tên");
        this.btnsave.setOnClickListener(view ->{
            final Intent data = new Intent();
            data.putExtra("Name", this.name.getText().toString());
            setResult(RESULT_OK, data);
            finish();
        });
    }
}
