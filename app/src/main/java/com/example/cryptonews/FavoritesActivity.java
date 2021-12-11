package com.example.cryptonews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cryptonews.databinding.ActivityHomeBinding;

public class FavoritesActivity extends DrawerBaseActivity {

    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Favorites");
    }
}