package com.example.wearapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wearapp.databinding.ActivityRatingBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class RatingActivity extends AppCompatActivity {

    EditText rate1;
    EditText rate2;
    TextView ocena1;
    TextView ocena2;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.wearapp.databinding.ActivityRatingBinding binding = ActivityRatingBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        ocena1 = findViewById(R.id.ocena1);
        rate1 = findViewById(R.id.Rate1);
        ocena2 = findViewById(R.id.ocena2);
        rate2 = findViewById(R.id.Rate2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        
        button1.setOnClickListener(view -> ocena1.setText(rate1.getText()));

        button2.setOnClickListener(view -> ocena2.setText(rate2.getText()));

    }
}