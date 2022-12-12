package com.tubes.kelompok9.cultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.textclassifier.TextLinks;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getSupportActionBar().hide();

        btnSubmit = findViewById(R.id.btn_submit);
    }
}