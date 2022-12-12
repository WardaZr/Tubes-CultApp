package com.tubes.kelompok9.cultapp.db;

import android.provider.BaseColumns;

/**
 * Created by YazidArroji on 30 oct 2022. UTS mobprog
 */

public class DatabaseKonten {

    public static final class NoteColumns implements BaseColumns {
        public static final String TABLE_NAME = "konten";

        //Note title
        public static final String IDUPLOAD = "id_uploader";
        //Note description
        public static final String JUDUL = "judul";
        //Note title
        public static final String KATEGORI = "kategori";
        //Note date
        public static final String FOTO = "foto";
        //Note date
        public static final String TGLUP = "tanggal_up";


    }
}
