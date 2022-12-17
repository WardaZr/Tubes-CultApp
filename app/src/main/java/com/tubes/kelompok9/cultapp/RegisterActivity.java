package com.tubes.kelompok9.cultapp;

import static com.tubes.kelompok9.cultapp.db.DatabaseUser.NoteColumnsUser.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.kelompok9.cultapp.entity.UserNotes;
import com.tubes.kelompok9.cultapp.db.UserNoteHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUname, edtEmail, edtPassword;
    private Button btnSubmit;

    private UserNotes User;
    private UserNoteHelper UserHelper;

    public static final String EXTRA_NOTE = "extra_note";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getSupportActionBar().hide();

        edtUname    = findViewById(R.id.reg_username);
        edtEmail    = findViewById(R.id.reg_email);
        edtPassword = findViewById(R.id.reg_password);
        btnSubmit   = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);

        UserHelper = UserHelper.getInstance(getApplicationContext());
        UserHelper.open();

        User = new UserNotes();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
            String username = edtUname.getText().toString().trim();
            String email    = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                edtUname.setError("Field can not be blank");
                return;
            }
            if (TextUtils.isEmpty(email)) {
                edtEmail.setError("Field can not be blank");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                edtPassword.setError("Field can not be blank");
                return;
            }

            User.setUsername(username);
            User.setEmail(email);
            User.setPassword(password);

            Intent intent = new Intent();
            intent.putExtra(EXTRA_NOTE, User);

            ContentValues values = new ContentValues();
            values.put(USERNAME, username);
            values.put(EMAIL, email);
            values.put(PASSWORD, password);

            long result = UserHelper.insert(values);

            if (result > 0) {
                User.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(RegisterActivity.this, "Gagal membuat akun", Toast.LENGTH_SHORT).show();
            }
        }
    }
}