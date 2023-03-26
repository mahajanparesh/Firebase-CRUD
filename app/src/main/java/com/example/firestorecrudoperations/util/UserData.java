package com.example.firestorecrudoperations.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.auth.User;

public class UserData implements Parcelable {
    String userID = "";
    String name = "";
    String profession = "";

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String age = "";

    public UserData(String _userID, String _name, String _profession, String _age){
        userID = _userID;
        name = _name;
        profession = _profession;
        age = _age;
    }
    public  UserData(){

    }


    protected UserData(Parcel in) {
        userID = in.readString();
        name = in.readString();
        profession = in.readString();
        age = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(userID);
        parcel.writeString(name);
        parcel.writeString(profession);
        parcel.writeString(age);
    }
}
