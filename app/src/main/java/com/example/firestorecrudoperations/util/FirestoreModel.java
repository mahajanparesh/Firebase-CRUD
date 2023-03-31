package com.example.firestorecrudoperations.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.firestorecrudoperations.ui.AddDetails;
import com.example.firestorecrudoperations.ui.GetDetails;
import com.example.firestorecrudoperations.ui.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import kotlin.Unit;

public class FirestoreModel {
    private FirebaseFirestore dbroot = FirebaseFirestore.getInstance();
    public void insertData(UserData userData, Activity activity){
        DocumentReference fireStoreRef = dbroot.collection("user").document(userData.userID);
        try{
            fireStoreRef.set(userData, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    if(activity instanceof AddDetails){
                        ((AddDetails) activity).userDataSuccess();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT);
        }

    }

    public void getData(String userID, Activity activity){
        DocumentReference fireStoreRef = dbroot.collection("user").document(userID);
        try{
            fireStoreRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists()){
                        UserData userData = documentSnapshot.toObject(UserData.class);
                        ((GetDetails) activity).userDataGetSuccess(userData);
                    }
                    else{
                        Toast.makeText(activity, "No User Data Found", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT);
        }

    }

    public void deleteData(String userID, Activity activity){
        DocumentReference fireStoreRef = dbroot.collection("user").document(userID);
        try{
            fireStoreRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    ((GetDetails) activity).userDataDeleteSuccess();
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT);
        }

    }

    public void updateData(String userId, HashMap<String, Object> userData, Activity activity){
        DocumentReference fireStoreRef = dbroot.collection("user").document(userId);
        try{

            fireStoreRef.update(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    if(activity instanceof GetDetails){
                        ((GetDetails) activity).userDataSuccess();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT);
        }

    }
}
