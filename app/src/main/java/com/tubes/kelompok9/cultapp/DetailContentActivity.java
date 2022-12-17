package com.tubes.kelompok9.cultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailContentActivity extends AppCompatActivity {

    private TextView tvJudul, tvAuthor, tvDesc;
    private ImageButton btnBack;
    private ImageView imgKonten;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_content);
        this.getSupportActionBar().hide();

        tvJudul   = findViewById(R.id.tv_item_judul);
        tvAuthor  = findViewById(R.id.tv_item_username);
        tvDesc    = findViewById(R.id.tv_item_konten);
        imgKonten = findViewById(R.id.img_item_konten);

        btnBack   = findViewById(R.id.btn_back);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(DetailContentActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(DetailContentActivity.this, UploadActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(DetailContentActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}