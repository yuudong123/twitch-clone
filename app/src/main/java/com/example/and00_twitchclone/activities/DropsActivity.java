package com.example.and00_twitchclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ActivityBroadcastBinding;
import com.example.and00_twitchclone.databinding.ActivityDropsBinding;

public class DropsActivity extends AppCompatActivity {

    ActivityDropsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDropsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}