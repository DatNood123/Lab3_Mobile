package com.example.mobile_lab3_520h0527;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai4_Profile extends AppCompatActivity {
    private ImageButton btnSetting;
    private TextView nameDisplay;
    private ImageView avatar;
    private TextView job;
    private TextView name;
    private TextView phone;
    private TextView mail;
    private TextView address;
    private TextView homepage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4_profile);

        btnSetting = findViewById(R.id.btnSetting);
        nameDisplay = findViewById(R.id.name_display);
        avatar = findViewById(R.id.avatar);
        job = findViewById(R.id.job);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mail = findViewById(R.id.mail);
        address = findViewById(R.id.address);
        homepage = findViewById(R.id.info);

        this.btnSetting.setOnClickListener(view->{
            Intent intent = new Intent(this, Bai4_Edit.class);
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("job", job.getText().toString());
            intent.putExtra("phone", phone.getText().toString());
            intent.putExtra("mail", mail.getText().toString());
            intent.putExtra("address", address.getText().toString());
            intent.putExtra("homepage", homepage.getText().toString());
            Bitmap avatar = ((BitmapDrawable) this.avatar.getDrawable()).getBitmap();
            intent.putExtra("avatar", avatar);
            startActivityForResult(intent,0x123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent respondData) {
        super.onActivityResult(requestCode, resultCode, respondData);

        if(requestCode == 0x123 && resultCode == RESULT_OK ){
            nameDisplay.setText(respondData.getStringExtra("name").toLowerCase().replace(' ', '_'));
            name.setText(respondData.getStringExtra("name"));
            job.setText(respondData.getStringExtra("job"));
            phone.setText(respondData.getStringExtra("phone"));
            mail.setText(respondData.getStringExtra("mail"));
            address.setText(respondData.getStringExtra("address"));
            homepage.setText(respondData.getStringExtra("homepage"));
            Bitmap avatar = respondData.getParcelableExtra("avatar");
            this.avatar.setImageBitmap(avatar);
        }
    }
}
