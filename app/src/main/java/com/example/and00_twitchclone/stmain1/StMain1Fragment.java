package com.example.and00_twitchclone.stmain1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentStMain1Binding;


public class StMain1Fragment extends Fragment {

    FragmentStMain1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentStMain1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}