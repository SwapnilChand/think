package com.example.think;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startBtn = findViewById(R.id.start);
        startBtn.setOnClickListener(v -> {
            Intent q1Intent = new Intent(MainActivity.this, LoginPage.class);
            startActivity(q1Intent);
        });
        ImageButton exitBtn = findViewById(R.id.exit);
        exitBtn.setOnClickListener(v -> System.exit(0));


    }
}