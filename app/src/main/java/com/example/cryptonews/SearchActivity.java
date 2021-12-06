package com.example.cryptonews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;

import com.example.cryptonews.databinding.ActivitySearchBinding;

public class SearchActivity extends DrawerBaseActivity {

    ActivitySearchBinding activitySearchBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(activitySearchBinding.getRoot());
        allocateActivityTitle("Search");

    }
}