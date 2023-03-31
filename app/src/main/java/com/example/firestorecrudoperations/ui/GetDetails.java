package com.example.firestorecrudoperations.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firestorecrudoperations.R;
import com.example.firestorecrudoperations.util.FirestoreModel;
import com.example.firestorecrudoperations.util.UserData;

import java.util.HashMap;

public class GetDetails extends AppCompatActivity {
    EditText txt_userID, txt_name, txt_profession, txt_age;
    Button btn_get, btn_update, btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_details);

        txt_userID = (EditText) findViewById(R.id.txt_userID);
        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_profession = (EditText) findViewById(R.id.txt_profession);
        txt_age = (EditText) findViewById(R.id.txt_age);
        btn_get = (Button) findViewById(R.id.btn_getData);
        btn_update = (Button) findViewById(R.id.btn_save);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FirestoreModel().getData(txt_userID.getText().toString(), GetDetails.this);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, Object> userHashMap = new HashMap<>();
                userHashMap.put("name", txt_name.getText().toString());
                userHashMap.put("profession", txt_profession.getText().toString());
                userHashMap.put("age", txt_age.getText().toString());
                new FirestoreModel().updateData(txt_userID.getText().toString(),userHashMap, GetDetails.this);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FirestoreModel().deleteData(txt_userID.getText().toString(), GetDetails.this);
            }
        });
    }

    public void userDataGetSuccess(UserData userData) {
        txt_name.setText(userData.getName());
        txt_profession.setText(userData.getProfession());
        txt_age.setText(userData.getAge());
    }

    public void userDataSuccess() {
        Toast.makeText(this, "Data updated successfully...", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(GetDetails.this, MainActivity.class);
        startActivity(i);
    }

    public void userDataDeleteSuccess() {
        Toast.makeText(this, "Data deleted successfully...", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(GetDetails.this, MainActivity.class);
        startActivity(i);
    }
}