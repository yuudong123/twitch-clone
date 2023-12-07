package com.example.and00_twitchclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ActivityBroadcastBinding;
import com.example.and00_twitchclone.databinding.ActivitySubscribeBinding;

public class SubscribeActivity extends AppCompatActivity {

    ActivitySubscribeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubscribeBinding.inflate(getLayoutInflater());

        binding.subscribeBtnClose.setOnClickListener(v->{
            finish();
        });

        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}