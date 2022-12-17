package com.tubes.kelompok9.cultapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class UserNotes implements Parcelable {
    private int id;
    private String username;
    private String email;
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(username);
        parcel.writeString(email);
        parcel.writeString(password);
    }

    public UserNotes() {

    }

    public UserNotes(Parcel in) {
        id = in.readInt();
        username = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<UserNotes> CREATOR = new Creator<UserNotes>() {
        @Override
        public UserNotes createFromParcel(Parcel in) {
            return new UserNotes(in);
        }

        @Override
        public UserNotes[] newArray(int size) {
            return new UserNotes[size];
        }
    };
}
