package com.example.and00_twitchclone;

import static com.example.and00_twitchclone.CommonVal.categoryList;
import static com.example.and00_twitchclone.CommonVal.userList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.and00_twitchclone.databinding.ActivityStartBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.StreamDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;
import java.util.Random;

public class StartActivity extends AppCompatActivity {

    ActivityStartBinding binding;


    int[] ProfImg = {R.drawable.profile_img1, R.drawable.profile_img2, R.drawable.profile_img3, R.drawable.profile_img4, R.drawable.profile_img5, R.drawable.profile_img6, R.drawable.profile_img7, R.drawable.profile_img8, R.drawable.profile_img9};
    int rdProfImg() {
        return ProfImg[new Random().nextInt(9)];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());

        /* =============== 초기정보 세팅 ========================= */

        if (userList.size()==0) {
            // 기본 유저 추가 ========================================================
            userList.add(new UserDTO("user0", "0000", "사용자0", rdProfImg(), new ArrayList<CategoryDTO>(), new ArrayList<UserDTO>()));

            // 카테고리 ==============================================================
            categoryList.add(new CategoryDTO("리그 오브 레전드", R.drawable.category_image1, new ArrayList<String>()));
            categoryList.add(new CategoryDTO("Hearthstone", R.drawable.category_image2, new ArrayList<String>()));
            categoryList.add(new CategoryDTO("Minecraft", R.drawable.category_image3, new ArrayList<String>()));
            categoryList.add(new CategoryDTO("Slay the Spire", R.drawable.category_image4, new ArrayList<String>()));
            categoryList.add(new CategoryDTO("작혼", R.drawable.category_image5, new ArrayList<String>()));
            categoryList.add(new CategoryDTO("Just Chatting", R.drawable.category_image6, new ArrayList<String>()));
            // =======================================================================

            // 카테고리 팔로우 =======================================
            userList.get(0).getFlwCategory().add(categoryList.get(0));
            userList.get(0).getFlwCategory().add(categoryList.get(1));
            userList.get(0).getFlwCategory().add(categoryList.get(2));
            userList.get(0).getFlwCategory().add(categoryList.get(3));
            // =======================================================

            // 다른 유저 (스트리머) 추가 ===============================
            for (int i = 1; i <= 20; i++) {
                userList.add(new UserDTO("another" + i, "0000", "다른사용자" + i, rdProfImg(), new ArrayList<CategoryDTO>(), new ArrayList<UserDTO>()));
            }
            for (int i = 1; i <= 10; i++) {
                userList.get(i).setStreamDTO(new StreamDTO("켜진방송" + i, (new Random().nextInt(100)) * 100, new ArrayList<String>(), true));
                userList.get(i).getStreamDTO().getTagList().add("한국어");
                userList.get(i + 10).setStreamDTO(new StreamDTO("꺼진방송" + i, 0, new ArrayList<String>(), false));
            }
            for (int i = 1; i <= 10; i++) {
                userList.get(i).getStreamDTO().setCategoryDTO(categoryList.get(new Random().nextInt(categoryList.size())));
            }
            // =======================================================

            // 스트리머 팔로우 =======================================
            userList.get(0).getFlwStreamer().add(userList.get(1));
            userList.get(0).getFlwStreamer().add(userList.get(2));
            userList.get(0).getFlwStreamer().add(userList.get(3));
            userList.get(0).getFlwStreamer().add(userList.get(4));
            userList.get(0).getFlwStreamer().add(userList.get(5));
            userList.get(0).getFlwStreamer().add(userList.get(11));
            userList.get(0).getFlwStreamer().add(userList.get(12));
            userList.get(0).getFlwStreamer().add(userList.get(13));
            userList.get(0).getFlwStreamer().add(userList.get(14));
            userList.get(0).getFlwStreamer().add(userList.get(15));
            // =======================================================
        }

        /* ======================================================= */


        /* =============== 로그인 및 회원가입 구현 =============== */
        String s = getIntent().getStringExtra("isLoginSuccess");
        if (s != null && s.equals("success")) {
            Toast.makeText(this, "반갑습니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            intent.putExtra("loginUser", getIntent().getSerializableExtra("loginUser"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        Log.d("userList", userList.size() + "");

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        binding.btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // 테스트를 위해 로그인 및 회원가입 기능 임시 처리함, 완료시 아래 지우고, 위 코드 주석해제

//        Intent intent = new Intent(StartActivity.this, MainActivity.class);
//        intent.putExtra("loginUser", userList.get(0));
//        startActivity(intent);
        /* ======================================================= */
        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}