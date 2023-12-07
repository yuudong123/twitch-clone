package com.example.and00_twitchclone.main4;

import static com.example.and00_twitchclone.CommonVal.categoryList;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultCategoryBinding;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultVideoBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;

public class Main4ResultCategoryFragment extends Fragment {
    FragmentMain4ResultCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4ResultCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        ArrayList<CategoryDTO> list = new ArrayList<>();
        for (CategoryDTO c : categoryList) {
            if (c.getName().contains(Main4Fragment.keyword)) {
                list.add(c);
            }
        }
        for (CategoryDTO c : list) {
            c.setViewer(0);
            for (UserDTO u : userList) {
                if (u.getId() != "user0" && u.getStreamDTO().isLive() && u.getStreamDTO().getCategoryDTO().getName().equals(c.getName())) {
                    c.setViewer(c.getViewer() + u.getStreamDTO().getViewer());
                }
            }
        }

        Main4ResultCategoryAdapter adapter = new Main4ResultCategoryAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.main4RecvCategory.setAdapter(adapter);
        binding.main4RecvCategory.setLayoutManager(manager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}