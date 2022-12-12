package com.tubes.kelompok9.cultapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView content_view;

    private TextView tvJudul;
    private ImageView imgKonten;

    private ImageButton btnBudaya, btnKuliner, btnTradisi, btnPariwisata;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        tvJudul      = findViewById(R.id.tv_item_judul);
        imgKonten    = findViewById(R.id.img_konten);
        content_view = findViewById(R.id.content_view);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        content_view.setLayoutManager(layoutManager);

        btnBudaya       = findViewById(R.id.btn_budaya);
        btnTradisi      = findViewById(R.id.btn_tradisi);
        btnKuliner      = findViewById(R.id.btn_kuliner);
        btnPariwisata   = findViewById(R.id.btn_pariwisata);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}