package com.example.firestorecrudoperations.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firestorecrudoperations.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //HashMap <String, String> map = new HashMap<String, String>();
    //FirebaseFirestore dbroot = FirebaseFirestore.getInstance();

    Button btn_add, btn_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //map.put("1", dbroot.toString());
       // dbroot.collection("users").document(String.valueOf(dbroot)).set(map);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_get = (Button) findViewById(R.id.btn_get);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddDetails.class);
                startActivity(i);
            }
        });
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GetDetails.class);
                startActivity(i);
            }
        });
    }
}