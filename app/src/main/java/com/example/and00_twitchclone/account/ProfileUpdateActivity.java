package com.example.and00_twitchclone.account;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ActivityProfileUpdateBinding;

public class ProfileUpdateActivity extends AppCompatActivity {

    public ActivityProfileUpdateBinding binding;
    public static int prfUdtPrev;
    public static TextView prfUdtTopTitle;
    public static TextView saveNick,saveIntro,saveSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.activityPrfUdtContainer, new ProfileUpdateFragment()).commit();
        prfUdtPrev = 0;
        prfUdtTopTitle = binding.activityPrfUdtTopTitle;
        saveNick = binding.saveNick;
        saveIntro = binding.saveIntro;
        saveSocial = binding.saveSocial;

        binding.activityPrfUdtBtnClose.setOnClickListener(v -> {
            if (prfUdtPrev == 0) {
                finish();
                return;
            }
            prfUdtPrev = 0;
            getSupportFragmentManager().beginTransaction().replace(R.id.activityPrfUdtContainer, new ProfileUpdateFragment()).commit();
            prfUdtTopTitle.setText("프로필 편집");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}