package com.example.and00_twitchclone.account;

import static com.example.and00_twitchclone.CommonVal.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.activities.DropsActivity;
import com.example.and00_twitchclone.activities.SubscribeActivity;
import com.example.and00_twitchclone.channel.ChannelActivity;
import com.example.and00_twitchclone.databinding.ActivityAccountBinding;
import com.example.and00_twitchclone.setting.SettingActivity;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.accountImage.setImageResource(user.getImage());
        binding.accountNickname.setText(user.getNickname() + "\n(" + user.getId() + ")");

        binding.accountBtnClose.setOnClickListener(this);
        binding.accountImage.setOnClickListener(this);
        binding.accountBtnMychannel.setOnClickListener(this);
        binding.accountBtnSubscribe.setOnClickListener(this);
        binding.accountBtnDrops.setOnClickListener(this);
        binding.accountBtnSetting.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        Class c = null;
        if (view.getId() == R.id.accountBtnMychannel || view.getId() == R.id.accountImage) {
            c = ChannelActivity.class;
        } else if (view.getId() == R.id.accountBtnSubscribe) {
            c = SubscribeActivity.class;
        } else if (view.getId() == R.id.accountBtnDrops) {
            c = DropsActivity.class;
        } else if (view.getId() == R.id.accountBtnSetting) {
            c = SettingActivity.class;
        }
        if (c != null) {
            Intent intent = new Intent(AccountActivity.this, c);
            if (view.getId() == R.id.accountBtnMychannel || view.getId() == R.id.accountImage) {
                intent.putExtra("UserDTO", user);
            }
            startActivity(intent);
        }
        finish();

    }
}