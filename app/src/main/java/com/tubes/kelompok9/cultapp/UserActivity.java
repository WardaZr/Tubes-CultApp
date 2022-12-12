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

public class UserActivity extends AppCompatActivity {

    private RecyclerView content_view;

    private TextView tvUsername, email;
    private ImageView imgProfil;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        this.getSupportActionBar().hide();

        tvUsername   = findViewById(R.id.tv_item_username);
        email        = findViewById(R.id.tv_item_email);
        imgProfil    = findViewById(R.id.img_profil);
        content_view = findViewById(R.id.content_view);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        content_view.setLayoutManager(layoutManager);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(UserActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(UserActivity.this, RegisterActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(UserActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}