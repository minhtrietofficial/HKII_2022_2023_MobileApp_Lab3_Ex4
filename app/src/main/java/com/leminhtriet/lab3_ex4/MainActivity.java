package com.leminhtriet.lab3_ex4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button editBtn;
    private TextView name, phone, email, address, homepage, job;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBtn = findViewById(R.id.button);
        name = findViewById(R.id.textView4);
        phone = findViewById(R.id.textView8);
        email = findViewById(R.id.textView9);
        address = findViewById(R.id.textView10);
        homepage = findViewById(R.id.textView11);
        job = findViewById(R.id.textView3);
        imageView = findViewById(R.id.imageView2);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("address", address.getText().toString());
                intent.putExtra("homepage", homepage.getText().toString());
                intent.putExtra("job", job.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                name.setText(data.getStringExtra("name"));
                phone.setText(data.getStringExtra("phone"));
                email.setText(data.getStringExtra("email"));
                address.setText(data.getStringExtra("address"));
                homepage.setText(data.getStringExtra("homepage"));
                job.setText(data.getStringExtra("job"));

                if (data.hasExtra("imageView")) {
                    imageView.setImageBitmap(data.getParcelableExtra("imageView"));
                }
            }

        }
    }
}
