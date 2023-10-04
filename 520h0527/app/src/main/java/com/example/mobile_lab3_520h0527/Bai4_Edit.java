package com.example.mobile_lab3_520h0527;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai4_Edit extends AppCompatActivity {

    private ImageView imgAvatar;
    private ImageButton btnChangeAvatar;
    private Button btnSave;
    private EditText editJob;
    private EditText editName;
    private EditText editPhone;
    private EditText editMail;
    private EditText editAddress;
    private EditText editHomePage;
    private TextView nameDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4_edit);

        imgAvatar = findViewById(R.id.avatar_display);
        btnChangeAvatar = findViewById(R.id.btnChangeImage);
        btnSave = findViewById(R.id.btnSaveInfo);
        editJob = findViewById(R.id.editJob);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editMail = findViewById(R.id.editMail);
        editAddress = findViewById(R.id.editAddress);
        editHomePage = findViewById(R.id.editLink);
        nameDisplay = findViewById(R.id.displayNameEdit);

        Bundle data = getIntent().getExtras();
        editName.setText(data.getString("name"));
        editJob.setText(data.getString("job"));
        editPhone.setText(data.getString("phone"));
        editMail.setText(data.getString("mail"));
        editAddress.setText(data.getString("address"));
        editHomePage.setText(data.getString("homepage"));
        nameDisplay.setText(data.getString("name"));
        imgAvatar.setImageBitmap(data.getParcelable("avatar"));

        this.btnChangeAvatar.setOnClickListener(view->{
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePicture, 0x1234);
        });

        this.btnSave.setOnClickListener(view->{
            Intent respondData = new Intent();
            respondData.putExtra("job", editJob.getText().toString());
            respondData.putExtra("name", editName.getText().toString());
            respondData.putExtra("phone", editPhone.getText().toString());
            respondData.putExtra("mail", editMail.getText().toString());
            respondData.putExtra("address", editAddress.getText().toString());
            respondData.putExtra("homepage", editHomePage.getText().toString());
            Bitmap avatar = ((BitmapDrawable) this.imgAvatar.getDrawable()).getBitmap();
            respondData.putExtra("avatar", avatar);
            setResult(RESULT_OK, respondData);
            finish();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x1234 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap) extras.get("data");
            this.imgAvatar.setImageBitmap(image);
        }
    }
}
