package com.example.and00_twitchclone.main1;

import static com.example.and00_twitchclone.CommonVal.user;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain1Binding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main1Fragment extends Fragment {

    FragmentMain1Binding binding;
    LayoutInflater inflater;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain1Binding.inflate(inflater, container, false);
        this.inflater = inflater;
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.mainBiding.layoutHeader.setVisibility(View.VISIBLE);
        // 카테고리 목록 생성 (시청자수 집계) =====================================
        ArrayList<CategoryDTO> flwCategory = user.getFlwCategory();
        for (CategoryDTO c : flwCategory) {
            c.setViewer(0);
            for (UserDTO u : userList) {
                if (u.getId() != "user0" && u.getStreamDTO().isLive() && u.getStreamDTO().getCategoryDTO().getName().equals(c.getName())) {
                    c.setViewer(c.getViewer() + u.getStreamDTO().getViewer());
                }
            }
        }
        // ========================================================================

        // 추천 목록 생성 (팔로우 X, 랜덤 5개) ====================================
        ArrayList<UserDTO> RecommendStream = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        while (set.size() < 5) {
            int num = new Random().nextInt(20) + 1;
            set.add(num);
        }
        for (int i : set.stream().mapToInt(Integer::intValue).toArray()) {
            if (!(user.getFlwStreamer(true).contains(userList.get(i)))&&userList.get(i).getStreamDTO().isLive()) {
                RecommendStream.add(userList.get(i));
            }
        }
        // ========================================================================

        // 어댑터, 레이아웃 매니저 ========================================================================================
        Main1CategoryAdapter categoryAdapter = new Main1CategoryAdapter(inflater, flwCategory);
        Main1LiveAdapter liveAdapter = new Main1LiveAdapter(inflater, user.getFlwStreamer(true));
        Main1RecommendAdapter recommendAdapter = new Main1RecommendAdapter(inflater, RecommendStream);
        Main1OfflineAdapter offlineAdapter = new Main1OfflineAdapter(inflater,user.getFlwStreamer(false));
        LinearLayoutManager managerV1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        LinearLayoutManager managerV2 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        LinearLayoutManager managerV3 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        LinearLayoutManager managerH = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        binding.RecvMenu1Category.setAdapter(categoryAdapter);
        binding.RecvMenu1Live.setAdapter(liveAdapter);
        binding.RecvMenu1Recommend.setAdapter(recommendAdapter);
        binding.RecvMenu1Offline.setAdapter(offlineAdapter);

        binding.RecvMenu1Category.setLayoutManager(managerH);
        binding.RecvMenu1Live.setLayoutManager(managerV1);
        binding.RecvMenu1Recommend.setLayoutManager(managerV2);
        binding.RecvMenu1Offline.setLayoutManager(managerV3);
        // ================================================================================================================
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}