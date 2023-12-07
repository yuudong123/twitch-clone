package com.example.and00_twitchclone.main3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentMain3Binding;
import com.google.android.material.tabs.TabLayout;

public class Main3Fragment extends Fragment {

    FragmentMain3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain3Binding.inflate(inflater, container, false);
        binding.main3Tabs.addTab(binding.main3Tabs.newTab().setText("카테고리"));
        binding.main3Tabs.addTab(binding.main3Tabs.newTab().setText("생방송 채널"));

        getChildFragmentManager().beginTransaction().replace(R.id.main3container, new Main3CategoryFragment()).commit();
        binding.main3Tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                int enter = 0;
                int exit = 0;
                Fragment fragment = null;
                if (i == 0) {
                    fragment = new Main3CategoryFragment();
                    enter = R.anim.enter_from_left;
                    exit = R.anim.exit_from_right;
                } else if (i == 1) {
                    fragment = new Main3LiveFragment();
                    enter = R.anim.enter_from_right;
                    exit = R.anim.exit_from_left;
                }
                getChildFragmentManager().beginTransaction().setCustomAnimations(enter, exit, enter, exit).replace(R.id.main3container, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.mainBiding.layoutHeader.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}