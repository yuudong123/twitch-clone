package com.example.and00_twitchclone.main4;

import static com.example.and00_twitchclone.CommonVal.MainMenuPrev;
import static com.example.and00_twitchclone.MainActivity.mainBiding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentMain4Binding;
import com.example.and00_twitchclone.main1.Main1Fragment;
import com.example.and00_twitchclone.main2.Main2Fragment;
import com.example.and00_twitchclone.main3.Main3Fragment;

import java.util.ArrayList;

public class Main4Fragment extends Fragment {

    FragmentMain4Binding binding;
    public static ArrayList<String> searchHistory = new ArrayList<>();
    public static String keyword;
    protected boolean showResult = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4Binding.inflate(inflater, container, false);

        getChildFragmentManager().beginTransaction().replace(R.id.main4container, new Main4HistoryFragment()).commit();
        binding.main4EdtSearch.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                keyword = binding.main4EdtSearch.getText().toString();
                searchHistory.add(keyword);
                getChildFragmentManager().beginTransaction().replace(R.id.main4container, new Main4ResultFragment()).commit();
                showResult = true;
            }
            return true;
        });

        binding.main4prev.setOnClickListener(v -> {
            Fragment fragment = null;
            if (!showResult) {
                if (MainMenuPrev == 1) {
                    fragment = new Main1Fragment();
                } else if (MainMenuPrev == 2) {
                    fragment = new Main2Fragment();
                } else if (MainMenuPrev == 3) {
                    fragment = new Main3Fragment();
                }
                if (fragment != null) {
                    if (MainMenuPrev == 1) {
                        mainBiding.bottomNav.setSelectedItemId(R.id.btnMenu1Tab);
                    } else if (MainMenuPrev == 2) {
                        mainBiding.bottomNav.setSelectedItemId(R.id.btnMenu2Tab);
                    } else if (MainMenuPrev == 3) {
                        mainBiding.bottomNav.setSelectedItemId(R.id.btnMenu3Tab);
                    }
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }
            } else {
                getChildFragmentManager().beginTransaction().replace(R.id.main4container, new Main4HistoryFragment()).commit();
                showResult = false;
            }
        });
        return binding.getRoot();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}