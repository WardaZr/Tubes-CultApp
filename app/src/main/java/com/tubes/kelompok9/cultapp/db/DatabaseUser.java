package com.tubes.kelompok9.cultapp.db;

import android.provider.BaseColumns;

public class DatabaseUser {

    public static final class NoteColumnsUser implements BaseColumns {
        public static final String TABLE_NAME_USER = "user";

        //Note title
        public static final String USERNAME = "username";
        //Note description
        public static final String EMAIL = "email";
        //Note title
        public static final String PASSWORD = "password";



    }
}
