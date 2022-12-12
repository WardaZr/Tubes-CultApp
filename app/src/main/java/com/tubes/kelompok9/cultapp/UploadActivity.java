package com.tubes.kelompok9.cultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UploadActivity extends AppCompatActivity {

    private Button btnUpload;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        this.getSupportActionBar().hide();

        btnUpload = findViewById(R.id.btn_upload);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(UploadActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(UploadActivity.this, UploadActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(UploadActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}