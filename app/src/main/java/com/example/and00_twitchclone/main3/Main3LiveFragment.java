package com.example.and00_twitchclone.main3;

import static com.example.and00_twitchclone.CommonVal.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.and00_twitchclone.databinding.FragmentMain3LiveBinding;

public class Main3LiveFragment extends Fragment {

    FragmentMain3LiveBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain3LiveBinding.inflate(inflater,container,false);

        Main3LiveAdapter adapter = new Main3LiveAdapter(inflater, user.getFlwStreamer(true));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.main3RecvLive.setAdapter(adapter);
        binding.main3RecvLive.setLayoutManager(manager);

        binding.main3LiveBtnSort.setOnClickListener(v->{
            Intent intent = new Intent(getContext(),Main3SortActivity.class);
            getContext().startActivity(intent);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}