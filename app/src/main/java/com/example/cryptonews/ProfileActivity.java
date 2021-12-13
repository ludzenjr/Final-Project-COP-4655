package com.example.cryptonews;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cryptonews.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends DrawerBaseActivity {

    ActivityProfileBinding activityProfileBinding;
    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");

    TextView userName;
    TextView nEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");
        userName = findViewById(R.id.userName);
        nEmail = findViewById(R.id.userEmail);
        //String id = mAuth.getCurrentUser().getUid();

        mAuth = FirebaseAuth.getInstance();




    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String id = user.getUid();
            DatabaseReference username = myRef.child(id).child("userName");
            DatabaseReference email = myRef.child(id).child("email");

            username.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String username = snapshot.getValue().toString();
                    userName.setText(username);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            email.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String email = snapshot.getValue().toString();
                    nEmail.setText(email);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            Toast.makeText(ProfileActivity.this, "Profile is working", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ProfileActivity.this, "Profile isnt working", Toast.LENGTH_SHORT).show();
        }


    }
}