package com.example.and00_twitchclone.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.CommonVal;
import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentProfileUpdateBinding;

public class ProfileUpdateFragment extends Fragment implements View.OnClickListener {

    FragmentProfileUpdateBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileUpdateBinding.inflate(inflater, container, false);
        View[] v = {binding.activityPrfUdtImageChange, binding.activityPrfUdtBannerChange,
                binding.activityPrfUdtIdChange, binding.activityPrfUdtNicknameChange,
                binding.activityPrfUdtIntroChange, binding.activityPrfUdtSocialChange};
        for (int i = 0; i < v.length; i++) {
            v[i].setOnClickListener(this);
        }

        binding.activityPrfUdtId.setText(CommonVal.user.getId());
        binding.activityPrfUdtNickname.setText(CommonVal.user.getNickname());
        binding.activityPrfUdtImage.setImageResource(CommonVal.user.getImage());
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        String title = "";
        if (view.getId() == R.id.activityPrfUdtImageChange) {

        } else if (view.getId() == R.id.activityPrfUdtBannerChange) {

        } else if (view.getId() == R.id.activityPrfUdtIdChange) {
            fragment = new ProfileUpdateIDFragment();
            title = "아이디 변경";
        } else if (view.getId() == R.id.activityPrfUdtNicknameChange) {
            fragment = new ProfileUpdateNickFragment();
            title = "닉네임";
            ProfileUpdateActivity.saveNick.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.activityPrfUdtIntroChange) {
            fragment = new ProfileUpdateIntroFragment();
            title = "자기 소개";
            ProfileUpdateActivity.saveIntro.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.activityPrfUdtSocialChange) {
            fragment = new ProfileUpdateSocialFragment();
            title = "소셜 링크";
        }
        if (fragment != null) {
            ProfileUpdateActivity.prfUdtPrev = 1;
            getParentFragmentManager().beginTransaction().replace(R.id.activityPrfUdtContainer, fragment).commit();
            ProfileUpdateActivity.prfUdtTopTitle.setText(title);
        }
    }
}