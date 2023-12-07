package com.example.and00_twitchclone.alim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentAlimBinding;

import java.util.ArrayList;
import java.util.Date;

public class AlimFragment extends Fragment {

    FragmentAlimBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAlimBinding.inflate(inflater,container,false);

        ArrayList<AlimDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new AlimDTO(R.drawable.alim_hearthstone," Hearthstone ", " 카드팩 ", new Date(),new Date()));
        }
        AlimAdapter adapter = new AlimAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.alimRecv.setAdapter(adapter);
        binding.alimRecv.setLayoutManager(manager);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}