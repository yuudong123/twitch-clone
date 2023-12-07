package com.example.and00_twitchclone.channel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.databinding.FragmentChannelInfoBinding;

public class ChannelInfoFragment extends Fragment {

    FragmentChannelInfoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}