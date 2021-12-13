package com.example.cryptonews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FavClass {
    DatabaseReference db;
    Boolean saved = null;
    ArrayList<CurrencyModal> currencyModals=new ArrayList<>();

    //Pass the Database Reference
    public FavClass(DatabaseReference db){
        this.db = db;
    }

    //Write if not null
    public Boolean save(CurrencyModal currencyModal){
        if(currencyModal==null){
            saved=false;
        }
        else{
            try{
                db.child("CurrencyModal").push().setValue(currencyModal);
                saved=true;
            }catch (DatabaseException e){
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }


    //Implement fetch data and fill arraylist
    private void fetchData(DataSnapshot dataSnapshot){
        currencyModals.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            CurrencyModal currencyModal = ds.getValue(CurrencyModal.class);
            currencyModal.add(currencyModal);
        }
    }

    //Read by hooking onto database operation callbacks
    public ArrayList<CurrencyModal> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                fetchData(snapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                fetchData(snapshot);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return currencyModals;
    }
}
