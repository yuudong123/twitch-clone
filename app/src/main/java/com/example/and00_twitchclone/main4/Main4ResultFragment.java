package com.example.and00_twitchclone.main4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultBinding;
import com.google.android.material.tabs.TabLayout;

public class Main4ResultFragment extends Fragment {

    FragmentMain4ResultBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4ResultBinding.inflate(inflater, container, false);

        binding.main4Tabs.addTab(binding.main4Tabs.newTab().setText("인기")); // 시청자순 채널, 카테고리
        binding.main4Tabs.addTab(binding.main4Tabs.newTab().setText("채널"));
        binding.main4Tabs.addTab(binding.main4Tabs.newTab().setText("카테고리"));
        binding.main4Tabs.addTab(binding.main4Tabs.newTab().setText("동영상")); // 한국은 못봐서 없음 ㅋㅋ

        getChildFragmentManager().beginTransaction().replace(R.id.main4ResultContainer, new Main4ResultIngiFragment()).commit();
        binding.main4Tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                Fragment fragment = null;
                if (i == 0) {
                    fragment = new Main4ResultIngiFragment();
                } else if (i == 1) {
                    fragment = new Main4ResultChannelFragment();
                } else if (i == 2) {
                    fragment = new Main4ResultCategoryFragment();
                } else if (i == 3) {
                    fragment = new Main4ResultVideoFragment();
                }
                getChildFragmentManager().beginTransaction().replace(R.id.main4ResultContainer, fragment).commit();
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
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}