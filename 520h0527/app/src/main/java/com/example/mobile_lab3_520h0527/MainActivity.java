package com.example.mobile_lab3_520h0527;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText email;
    private TextView welcome;
    public static final String EXTRA_MESSAGE_KEY = "com.example.android.twoactivities.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        welcome = findViewById(R.id.welcome);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Input_Name.class);
                intent.putExtra("email", email.getText().toString());
                startActivityForResult(intent,  0x24);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0x24) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra("Name");
                this.welcome.setText("Hẹn gặp lại");
                this.email.setText(reply);
                this.btnLogin.setVisibility(View.GONE);
            }}
    }
}