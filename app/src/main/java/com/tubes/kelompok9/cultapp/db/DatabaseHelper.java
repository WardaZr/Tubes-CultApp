package com.tubes.kelompok9.cultapp.db;

import static com.tubes.kelompok9.cultapp.db.DatabaseKonten.NoteColumns.TABLE_NAME;
import static com.tubes.kelompok9.cultapp.db.DatabaseUser.NoteColumnsUser.TABLE_NAME_USER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tubes.kelompok9.cultapp.db.DatabaseKonten.NoteColumns;
import com.tubes.kelompok9.cultapp.db.DatabaseUser.NoteColumnsUser;

/**
 * Created by YazidArroji on 30 oct 2022. UTS mobprog
 */

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cultapp";

    private static final int DATABASE_VERSION = 3;
    /* To Do Lengkapi Struktur Kode Create SQLnya */
    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s DATE NOT NULL)",
            TABLE_NAME,
            NoteColumns._ID,
            NoteColumns.IDUPLOAD,
            NoteColumns.JUDUL,
            NoteColumns.KATEGORI,
            NoteColumns.FOTO,
            NoteColumns.TGLUP
    );
    private static final String SQL_CREATE_TABLE_USER = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s DATE NOT NULL)",
            TABLE_NAME_USER,
            NoteColumnsUser._ID,
            NoteColumnsUser.USERNAME,
            NoteColumnsUser.EMAIL,
            NoteColumnsUser.PASSWORD
    );

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    /*
    Method onUpgrade akan di panggil ketika terjadi perbedaan versi
    Gunakan method onUpgrade untuk melakukan proses migrasi data
     */
    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        Drop table tidak dianjurkan ketika proses migrasi terjadi dikarenakan data user akan hilang,
        */
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
