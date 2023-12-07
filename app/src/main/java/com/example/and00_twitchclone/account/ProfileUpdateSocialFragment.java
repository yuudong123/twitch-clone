package com.example.and00_twitchclone.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentProfileUpdateSocialBinding;

public class ProfileUpdateSocialFragment extends Fragment {

    FragmentProfileUpdateSocialBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileUpdateSocialBinding.inflate(inflater, container, false);

//        binding.addSocialLinkBtn.setOnClickListener(v->{
//            ProfileUpdateActivity.saveSocial.setVisibility(View.VISIBLE);
//            ProfileUpdateActivity.prfUdtTopTitle.setText("소셜 링크 추가");
//            binding.proUdtSocial.setVisibility(View.GONE);
//            binding.proUdtSocialAdd.setVisibility(View.VISIBLE);
//        });
//        ProfileUpdateActivity.saveSocial.setOnClickListener(v->{
//            ProfileUpdateActivity.saveSocial.setVisibility(View.GONE);
//            binding.proUdtSocialAdd.setVisibility(View.GONE);
//            binding.proUdtSocial.setVisibility(View.VISIBLE);
//            ProfileUpdateActivity.prfUdtTopTitle.setText("소셜 링크");
//        });
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}