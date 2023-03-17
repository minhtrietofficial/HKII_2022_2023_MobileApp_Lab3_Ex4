package com.leminhtriet.lab3_ex4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private Button saveBtn, takePicBtn;
    private TextView name, phone, email, address, homepage, job;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        saveBtn = findViewById(R.id.button2);
        takePicBtn =findViewById(R.id.button);

        name = findViewById(R.id.Name);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.Email);
        address = findViewById(R.id.Address);
        homepage = findViewById(R.id.Homepage);
        job = findViewById(R.id.Job);
        imageView = findViewById(R.id.imageView2);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("address", address.getText().toString());
                intent.putExtra("homepage", homepage.getText().toString());
                intent.putExtra("job", job.getText().toString());


                setResult(RESULT_OK, intent);
                finish();
            }
        });

        takePicBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            intent.putExtra("imageView", photo);
        }
    }
}