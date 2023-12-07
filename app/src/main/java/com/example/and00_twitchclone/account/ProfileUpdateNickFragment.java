package com.example.and00_twitchclone.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentProfileUpdateNickBinding;

public class ProfileUpdateNickFragment extends Fragment {
    FragmentProfileUpdateNickBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileUpdateNickBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}