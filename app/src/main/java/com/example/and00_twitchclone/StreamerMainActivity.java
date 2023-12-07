package com.example.and00_twitchclone;

import static com.example.and00_twitchclone.CommonVal.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.account.AccountActivity;
import com.example.and00_twitchclone.alim.AlimFragment;
import com.example.and00_twitchclone.databinding.ActivityStreamerMainBinding;
import com.example.and00_twitchclone.stmain1.StMain1Fragment;
import com.example.and00_twitchclone.stmain2.StMain2Fragment;
import com.example.and00_twitchclone.stmain3.StMain3Fragment;
import com.example.and00_twitchclone.whisper.WhisperFragment;

public class StreamerMainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ActivityStreamerMainBinding StreamerMainBiding;
    int StreamerMenuPrev = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StreamerMainBiding = ActivityStreamerMainBinding.inflate(getLayoutInflater());
        setContentView(StreamerMainBiding.getRoot());

        StreamerMainBiding.ivStreamerProfile.setImageResource(user.getImage());
        getSupportFragmentManager().beginTransaction().replace(R.id.streamerContainer, new StMain1Fragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        /* ========== 메인화면 전환 ========== */
        StreamerMainBiding.streamerBottomNav.setOnItemSelectedListener(menu -> {
            Fragment fragment = null;
            int enter = 0;
            int exit = 0;
            if (menu.getItemId() == R.id.btnStreamerMenu1Tab && StreamerMenuPrev != 1) {
                StreamerMenuPrev = 1;
                fragment = new StMain1Fragment();
                enter = R.anim.enter_from_left;
                exit = R.anim.exit_from_right;
            } else if (menu.getItemId() == R.id.btnStreamerMenu2Tab && StreamerMenuPrev != 2) {
                if (StreamerMenuPrev == 3) {
                    enter = R.anim.enter_from_left;
                    exit = R.anim.exit_from_right;
                } else {
                    enter = R.anim.enter_from_right;
                    exit = R.anim.exit_from_left;
                }
                StreamerMenuPrev = 2;
                fragment = new StMain2Fragment();
            } else if (menu.getItemId() == R.id.btnStreamerMenu3Tab && StreamerMenuPrev != 3) {
                enter = R.anim.enter_from_right;
                exit = R.anim.exit_from_left;
                StreamerMenuPrev = 3;
                fragment = new StMain3Fragment();
            } else {
                return false;
            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(enter, exit, enter, exit).replace(R.id.streamerContainer, fragment).commit();
            }
            return true;
        });
        /* =================================== */

        /* ============ 헤더 버튼 ============ */
        StreamerMainBiding.ivStreamerProfile.setOnClickListener(this);
        StreamerMainBiding.btnStreamerAlim.setOnClickListener(this);
        StreamerMainBiding.btnStreamerWhisper.setOnClickListener(this);
        StreamerMainBiding.layoutBtnGoMain.setOnClickListener(this);
        /* =================================== */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StreamerMainBiding = null;
    }

    @Override
    public void onClick(View view) {
        Class c = null;
        Fragment f = null;
        if (view.getId() == R.id.ivStreamerProfile) {
            c = AccountActivity.class;
        } else if (view.getId() == R.id.btnStreamerAlim) {
            f = new AlimFragment();
            StreamerMenuPrev = 0;
        } else if (view.getId() == R.id.btnStreamerWhisper) {
            f = new WhisperFragment();
            StreamerMenuPrev = 0;
        } else if (view.getId() == R.id.layoutBtnGoMain) {
            finish();
        }
        if (c != null) {
            Intent intent = new Intent(StreamerMainActivity.this, c);
            startActivity(intent);
        } else if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.streamerContainer, f).commit();
        }
    }
}