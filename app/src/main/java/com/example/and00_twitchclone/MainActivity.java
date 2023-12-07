package com.example.and00_twitchclone;

import static com.example.and00_twitchclone.CommonVal.MainMenuPrev;
import static com.example.and00_twitchclone.CommonVal.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.account.AccountActivity;
import com.example.and00_twitchclone.alim.AlimFragment;
import com.example.and00_twitchclone.databinding.ActivityMainBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.main1.Main1Fragment;
import com.example.and00_twitchclone.main2.Main2Fragment;
import com.example.and00_twitchclone.main3.Main3Fragment;
import com.example.and00_twitchclone.main4.Main4Fragment;
import com.example.and00_twitchclone.whisper.WhisperFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ActivityMainBinding mainBiding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBiding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBiding.getRoot());

        user = (UserDTO) getIntent().getSerializableExtra("loginUser");
        mainBiding.ivProfile.setImageResource(user.getImage());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Main1Fragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        /* ========== 메인화면 전환 ========== */
        mainBiding.bottomNav.setOnItemSelectedListener(menu -> {
            Fragment fragment = null;
            int enter = 0;
            int exit = 0;
            if (menu.getItemId() == R.id.btnMenu1Tab && MainMenuPrev != 1) {
                MainMenuPrev = 1;
                fragment = new Main1Fragment();
                enter = R.anim.enter_from_left;
                exit = R.anim.exit_from_right;
            } else if (menu.getItemId() == R.id.btnMenu2Tab && MainMenuPrev != 2) {
                if (MainMenuPrev == 1) {
                    enter = R.anim.enter_from_right;
                    exit = R.anim.exit_from_left;
                } else {
                    enter = R.anim.enter_from_left;
                    exit = R.anim.exit_from_right;
                }
                MainMenuPrev = 2;
                fragment = new Main2Fragment();
            } else if (menu.getItemId() == R.id.btnMenu3Tab && MainMenuPrev != 3) {
                if (MainMenuPrev == 4) {
                    enter = R.anim.enter_from_left;
                    exit = R.anim.exit_from_right;
                } else {
                    enter = R.anim.enter_from_right;
                    exit = R.anim.exit_from_left;
                }
                MainMenuPrev = 3;
                fragment = new Main3Fragment();
            } else if (menu.getItemId() == R.id.btnMenu4Tab && MainMenuPrev != 4) {
                enter = R.anim.enter_from_right;
                exit = R.anim.exit_from_left;
                MainMenuPrev = 4;
                fragment = new Main4Fragment();
                mainBiding.layoutHeader.setVisibility(View.GONE);
            } else {
                return false;
            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(enter, exit, enter, exit).replace(R.id.container, fragment).commit();
            }
            return true;
        });
        /* =================================== */

        /* ============ 헤더 버튼 ============ */
        mainBiding.ivProfile.setOnClickListener(this);
        mainBiding.btnAlim.setOnClickListener(this);
        mainBiding.btnWhisper.setOnClickListener(this);
        mainBiding.layoutBtnBroadcast.setOnClickListener(this);
        /* =================================== */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainBiding = null;
    }

    @Override
    public void onClick(View view) {
        Class c = null;
        Fragment f = null;
        if (view.getId() == R.id.ivProfile) {
            c = AccountActivity.class;
        } else if (view.getId() == R.id.btnAlim) {
            f = new AlimFragment();
            MainMenuPrev = 0;
        } else if (view.getId() == R.id.btnWhisper) {
            f = new WhisperFragment();
            MainMenuPrev = 0;
        } else if (view.getId() == R.id.layoutBtnBroadcast) {
            c = StreamerMainActivity.class;
        }
        if (c != null) {
            Intent intent = new Intent(MainActivity.this, c);
            startActivity(intent);
        } else if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
        }
    }
}