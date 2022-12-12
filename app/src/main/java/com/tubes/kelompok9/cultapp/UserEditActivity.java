package com.tubes.kelompok9.cultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserEditActivity extends AppCompatActivity {

    private EditText edtUsername;
    private Button btnSave, btnEditphoto;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
        this.getSupportActionBar().hide();

        edtUsername  = findViewById(R.id.edt_edit_uname);
        btnSave      = findViewById(R.id.btn_save_user);
        btnEditphoto = findViewById(R.id.btn_edit_profile);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent home = new Intent(UserEditActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                    break;
                case R.id.menu_add:
                    Intent add = new Intent(UserEditActivity.this, UploadActivity.class);
                    startActivity(add);
                    finish();
                    break;
                case R.id.menu_profil:
                    Intent user = new Intent(UserEditActivity.this, UserActivity.class);
                    startActivity(user);
                    finish();
                    break;
            }
            return true;
        });
    }
}