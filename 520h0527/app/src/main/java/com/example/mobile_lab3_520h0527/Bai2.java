package com.example.mobile_lab3_520h0527;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Bai2 extends AppCompatActivity {
    private Button open;
    private EditText link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);

        open = findViewById(R.id.open);
        link = findViewById(R.id.link);

        open.setOnClickListener(view ->{
            String link = this.link.getText().toString();

            String regex = "^https*://.*";
            Pattern pattern = Pattern.compile(regex);

            if(pattern.matcher(link).matches()){
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(link));
                startActivity(browser);
            }else{
                Toast.makeText(this, "Wrong link format", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
