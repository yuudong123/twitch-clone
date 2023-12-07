package com.example.and00_twitchclone.main2;

import static com.example.and00_twitchclone.CommonVal.categoryList;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain2Binding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.main1.Main1CategoryAdapter;
import com.example.and00_twitchclone.main1.Main1LiveAdapter;
import com.example.and00_twitchclone.main1.Main1OfflineAdapter;
import com.example.and00_twitchclone.main1.Main1RecommendAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Main2Fragment extends Fragment {

    FragmentMain2Binding binding;
    LayoutInflater inflater;
    @Override
    public View onCreateView(LayoutInflater inflaterr, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain2Binding.inflate(inflaterr,container,false);
        inflater = inflaterr;
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.mainBiding.layoutHeader.setVisibility(View.VISIBLE);
        // 추천 목록 생성 (팔로우 X) ====================================
        ArrayList<UserDTO> topList = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            topList.add(userList.get(i));
        }

        ArrayList<UserDTO> liveList = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            liveList.add(userList.get(i));
        }

        ArrayList<UserDTO> highViewerList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            highViewerList.add(userList.get(i));
        }
        Collections.sort(highViewerList);
        // ==============================================================

        // 상단 캐러셀 ========================================================================================
        ViewPager2 vp = binding.menu2vpTop;
        Main2TopAdapter adapter = new Main2TopAdapter(inflater,topList);

        vp.setAdapter(adapter);
        vp.setCurrentItem(0,false);
        binding.menu2TopStreamer.setText(adapter.list.get(0).getNickname());
        binding.menu2TopCategory.setText(adapter.list.get(0).getStreamDTO().getCategoryDTO().getName());
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    vp.setCurrentItem(adapter.list.size(), false);
                } else if (position == adapter.MAX_VALUE - 1) {
                    vp.setCurrentItem(adapter.list.size() - 1, false);
                }
                binding.menu2TopStreamer.setText(adapter.list.get(position%5).getNickname());
                binding.menu2TopCategory.setText(adapter.list.get(position%5).getStreamDTO().getCategoryDTO().getName());
            }
        });
        vp.setPageTransformer((page, position) -> {
            if (position == -1) {
                vp.setCurrentItem(adapter.list.size() - 1, false);
            } else if (position == 1) {
                vp.setCurrentItem(1, false);
            }
        });
        // ====================================================================================================

        // 카테고리 목록 생성 (시청자수 집계) =====================================
        ArrayList<CategoryDTO> categoryViewer = new ArrayList<>(categoryList);
        for (CategoryDTO c : categoryViewer) {
            c.setViewer(0);
            for (UserDTO u : userList) {
                if (u.getId() != "user0" && u.getStreamDTO().isLive() && u.getStreamDTO().getCategoryDTO().getName().equals(c.getName())) {
                    c.setViewer(c.getViewer() + u.getStreamDTO().getViewer());
                }
            }
        }
        Collections.sort(categoryViewer);
        // ========================================================================

        // 어댑터, 레이아웃 매니저 ========================================================================================
        Main2LiveAdapter liveAdapter = new Main2LiveAdapter(inflater, liveList);
        Main2CategoryAdapter categoryAdapter = new Main2CategoryAdapter(inflater, categoryViewer);
        Main2HighViewerAdapter highViewerAdapter = new Main2HighViewerAdapter(inflater, highViewerList);
        LinearLayoutManager managerV1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager managerV2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager managerV3 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        binding.menu2RecvLive.setAdapter(liveAdapter);
        binding.menu2RecvCategory.setAdapter(categoryAdapter);
        binding.menu2RecvHighViewer.setAdapter(highViewerAdapter);

        binding.menu2RecvLive.setLayoutManager(managerV1);
        binding.menu2RecvCategory.setLayoutManager(managerV2);
        binding.menu2RecvHighViewer.setLayoutManager(managerV3);
        // ================================================================================================================
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}