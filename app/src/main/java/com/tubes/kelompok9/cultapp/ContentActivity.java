package com.tubes.kelompok9.cultapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tubes.kelompok9.cultapp.adapter.ContentNotesAdapter;
import com.tubes.kelompok9.cultapp.entity.ContentNotes;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {
    private RecyclerView content_view;
    private ArrayList<ContentNotes> contentDataList;
    private ContentNotesAdapter adapter;

    TextView tvJudul;
    ImageView imgKonten;
    private TextView tvJudulkonten;
    public static final String EXTRA_NAME = "extra_name";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        this.getSupportActionBar().hide();

        tvJudulkonten = findViewById(R.id.tv_kategoriTitle);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvJudulkonten.setText(name);

        tvJudul      = findViewById(R.id.tv_item_judul);
        imgKonten    = findViewById(R.id.img_konten);
        content_view = findViewById(R.id.content_view);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(ContentActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(ContentActivity.this, UploadActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(ContentActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}
