package com.example.and00_twitchclone.setting;

import static com.example.and00_twitchclone.CommonVal.user;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySettingBinding binding;
    View currentMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());

        binding.activitySettingBtnClose.setOnClickListener(v -> {
            if (currentMenu == binding.settingMenuMainTab) {
                finish();
            } else {
                currentMenu.setVisibility(View.GONE);
                binding.settingMenuMainTab.setVisibility(View.VISIBLE);
                currentMenu = binding.settingMenuMainTab;
                binding.activitySettingTitle.setText("설정");
            }
        });
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentMenu = binding.settingMenuMainTab;
        currentMenu.setVisibility(View.VISIBLE);
        binding.activitySettingTitle.setText("설정");
        View[] menus = {binding.settingMenu1, binding.settingMenu2,
                binding.settingMenu3, binding.settingMenu4, binding.settingMenu5,
                binding.settingMenu6, binding.settingMenu7, binding.settingMenu12};
        View[] linkmenu = {binding.settingMenu8, binding.settingMenu9, binding.settingMenu10, binding.settingMenu11};
        View[] menutabs = {binding.settingMenu1Tab, binding.settingMenu2Tab,
                binding.settingMenu3Tab, binding.settingMenu4Tab, binding.settingMenu5Tab,
                binding.settingMenu6Tab, binding.settingMenu7Tab, binding.settingMenu12Tab};
        String[] titles = {"계정","개인 설정", "알림","보안 및 개인정보 보호","추천","연결","시스템","사업자 정보"};

        for (int i = 0; i < menus.length; i++) {
            final int index = i;
            menus[index].setOnClickListener(v -> {
                currentMenu.setVisibility(View.GONE);
                currentMenu = menutabs[index];
                currentMenu.setVisibility(View.VISIBLE);
                binding.activitySettingTitle.setText(titles[index]);
            });
        }

        for (View menu : linkmenu) {
            menu.setOnClickListener(this);
        }

        binding.settingMenuLogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("현재 " + user.getNickname() + "(" + user.getId() + ")(으)로 로그인되었습니다. 로그아웃하시겠습니까?");
            builder.setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    user = null;
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onBackPressed() {
        if (currentMenu == binding.settingMenuMainTab) {
            finish();
        } else {
            currentMenu.setVisibility(View.GONE);
            binding.settingMenuMainTab.setVisibility(View.VISIBLE);
            currentMenu = binding.settingMenuMainTab;
            binding.activitySettingTitle.setText("설정");
        }
    }

    @Override
    public void onClick(View view) {
        String uri = null;
        if (view.getId() == binding.settingMenu8.getId()) {
            uri = "https://safety.twitch.tv/s/article/Community-Guidelines?language=ko";
        } else if (view.getId() == binding.settingMenu9.getId()) {
            uri = "https://help.twitch.tv/s/?language=ko";
        } else if (view.getId() == binding.settingMenu10.getId()) {
            uri = "https://www.twitch.tv/p/ko-kr/legal/terms-of-service/";
        } else if (view.getId() == binding.settingMenu11.getId()) {
            uri = "https://www.twitch.tv/p/ko-kr/legal/privacy-notice/";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
}