package com.example.and00_twitchclone.main4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultCategoryBinding;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultVideoBinding;

public class Main4ResultVideoFragment extends Fragment {
    FragmentMain4ResultVideoBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4ResultVideoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}