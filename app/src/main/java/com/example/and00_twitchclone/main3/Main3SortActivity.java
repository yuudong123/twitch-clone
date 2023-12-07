package com.example.and00_twitchclone.main3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ActivityMain3SortBinding;

public class Main3SortActivity extends AppCompatActivity {

    ActivityMain3SortBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3SortBinding.inflate(getLayoutInflater());

        binding.main3BtnSortClose.setOnClickListener(v->{
            finish();
        });
        setContentView(binding.getRoot());
    }@Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}