package com.example.Laundry13451;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.Laundry13451.R;

public class MainActivity extends AppCompatActivity {

    Button tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tombol = findViewById(R.id.btn);

        tombol.setOnClickListener(v -> {
            Intent intent = new Intent(this, recycle_view.class);
            startActivity(intent);
        });
    }
}