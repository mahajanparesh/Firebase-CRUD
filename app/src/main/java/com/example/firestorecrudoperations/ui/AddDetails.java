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

public class AddDetails extends AppCompatActivity {
    EditText txt_userID, txt_name, txt_profession, txt_age;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        txt_userID = (EditText) findViewById(R.id.txt_userID);
        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_profession = (EditText) findViewById(R.id.txt_profession);
        txt_age = (EditText) findViewById(R.id.txt_age);
        btn_save = (Button) findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData userData = new UserData(txt_userID.getText().toString(), txt_name.getText().toString(), txt_profession.getText().toString(), txt_age.getText().toString());
                new FirestoreModel().insertData(userData, AddDetails.this);
            }
        });
    }

    public void userDataSuccess() {
        Toast.makeText(this, "Data saved successfully...", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(AddDetails.this, MainActivity.class);
        startActivity(i);
    }
}