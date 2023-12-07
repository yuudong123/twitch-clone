package com.example.and00_twitchclone.main4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentMain4HistoryBinding;

import java.util.ArrayList;

public class Main4HistoryFragment extends Fragment {

    FragmentMain4HistoryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4HistoryBinding.inflate(inflater,container,false);

        Main4HistoryAdapter adapter = new Main4HistoryAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.main4HistoryRecv.setAdapter(adapter);
        binding.main4HistoryRecv.setLayoutManager(manager);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}