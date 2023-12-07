package com.example.and00_twitchclone.main4;

import static com.example.and00_twitchclone.CommonVal.categoryList;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultIngiBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;
import java.util.Collections;

public class Main4ResultIngiFragment extends Fragment {

    FragmentMain4ResultIngiBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4ResultIngiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        ArrayList<UserDTO> channelList = new ArrayList<>();
        for (UserDTO u : userList) {
            if (u.getNickname().contains(Main4Fragment.keyword) || u.getId().contains(Main4Fragment.keyword)) {
                channelList.add(u);
            }
        }
        Collections.sort(channelList);
        while (channelList.size() > 3) {
            channelList.remove(channelList.size() - 1);
        }

        ArrayList<CategoryDTO> catelist = new ArrayList<>();
        for (CategoryDTO c : categoryList) {
            if (c.getName().contains(Main4Fragment.keyword)) {
                catelist.add(c);
            }
        }
        for (CategoryDTO c : catelist) {
            c.setViewer(0);
            for (UserDTO u : userList) {
                if (u.getId() != "user0" && u.getStreamDTO().isLive() && u.getStreamDTO().getCategoryDTO().getName().equals(c.getName())) {
                    c.setViewer(c.getViewer() + u.getStreamDTO().getViewer());
                }
            }
        }
        Collections.sort(catelist);
        while (catelist.size() > 3) {
            catelist.remove(catelist.size() - 1);
        }

        Main4ResultChannelAdapter channelAdapter = new Main4ResultChannelAdapter(channelList);
        Main4ResultCategoryAdapter categoryAdapter = new Main4ResultCategoryAdapter(catelist);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
        binding.main4RecvIngiChannel.setAdapter(channelAdapter);
        binding.main4RecvIngiCategory.setAdapter(categoryAdapter);
        binding.main4RecvIngiChannel.setLayoutManager(manager1);
        binding.main4RecvIngiCategory.setLayoutManager(manager2);

        binding.main4BtnChannelSeeAll.setOnClickListener(v->{
            getParentFragmentManager().beginTransaction().replace(R.id.main4ResultContainer,new Main4ResultChannelFragment());
        });
        binding.main4BtnCategorySeeAll.setOnClickListener(v->{
            getParentFragmentManager().beginTransaction().replace(R.id.main4ResultContainer,new Main4ResultCategoryFragment());
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}