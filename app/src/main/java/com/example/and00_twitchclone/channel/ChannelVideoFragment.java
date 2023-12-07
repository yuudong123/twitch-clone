package com.example.and00_twitchclone.channel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.databinding.FragmentChannelVideoBinding;

public class ChannelVideoFragment extends Fragment {

    FragmentChannelVideoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelVideoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}