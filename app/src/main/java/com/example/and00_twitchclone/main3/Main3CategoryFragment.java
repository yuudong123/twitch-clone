package com.example.and00_twitchclone.main3;

import static com.example.and00_twitchclone.CommonVal.categoryList;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain3CategoryBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;
import java.util.Collections;

public class Main3CategoryFragment extends Fragment {

    FragmentMain3CategoryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain3CategoryBinding.inflate(inflater,container,false);

        // ====== 카테고리 시청자 집계 =========================================
        ArrayList<CategoryDTO> categoryViewer = new ArrayList<>(categoryList);
        for (CategoryDTO c : categoryViewer) {
            c.setViewer(0);
            for (UserDTO u : userList) {
                if (u.getId() != "user0" && u.getStreamDTO().isLive() && u.getStreamDTO().getCategoryDTO().getName().equals(c.getName())) {
                    c.setViewer(c.getViewer() + u.getStreamDTO().getViewer());
                }
            }
        }
        // =====================================================================

        Main3CategoryAdapter adapter = new Main3CategoryAdapter(categoryViewer);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.main3RecvCategory.setAdapter(adapter);
        binding.main3RecvCategory.setLayoutManager(manager);

        binding.main3CategoryBtnSort.setOnClickListener(v->{
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