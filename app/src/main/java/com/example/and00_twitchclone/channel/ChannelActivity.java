package com.example.and00_twitchclone.channel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.CommonVal;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.account.ProfileUpdateActivity;
import com.example.and00_twitchclone.databinding.ActivityChannelBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.google.android.material.tabs.TabLayout;

public class ChannelActivity extends AppCompatActivity {

    ActivityChannelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChannelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("홈"));
        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("정보"));
        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("일정"));
        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("동영상")); // 한국은 못봐서 없음
        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("클립")); // 이것도 없음
        binding.activityChannelTabs.addTab(binding.activityChannelTabs.newTab().setText("채팅"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        UserDTO user = (UserDTO) getIntent().getSerializableExtra("UserDTO");

        binding.activityChannelProfile.setImageResource(user.getImage());
        binding.activityChannelFollower.setText("팔로워 " + user.getFollowerFormat() + "명");
        binding.activityChannelNickname.setText(user.getNickname());
        binding.activityChannelOnOff.setText(user.getStreamDTO().isLive() ? "온라인" : "오프라인");
        binding.activityChannelBtnClose.setOnClickListener(v -> {
            finish();
        });
        binding.activityChannelModify.setVisibility(user.equals(
                CommonVal.user) ? View.VISIBLE : View.GONE);
        binding.activityChannelModify.setOnClickListener(v -> {
            Intent intent = new Intent(ChannelActivity.this, ProfileUpdateActivity.class);
            startActivity(intent);
        });



        Fragment fragment = new ChannelHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("UserDTO", user);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.activityChannelContainer, fragment).commit();
        binding.activityChannelTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                Fragment fragment = null;
                if (i == 0) {
                    fragment = new ChannelHomeFragment();
                } else if (i == 1) {
                    fragment = new ChannelInfoFragment();
                } else if (i == 2) {
                    fragment = new ChannelScheduleFragment();
                } else if (i == 3) {
                    fragment = new ChannelVideoFragment();
                } else if (i == 4) {
                    fragment = new ChannelClipFragment();
                } else if (i == 5) {
                    fragment = new ChannelChatFragment();
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("UserDTO", user);
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.activityChannelContainer, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}