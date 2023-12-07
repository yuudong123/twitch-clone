package com.example.and00_twitchclone;

import static com.example.and00_twitchclone.CommonVal.userList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.and00_twitchclone.databinding.ActivityRegisterBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        binding.btnRegisterSubmit.setOnClickListener(v -> {
            String id = binding.edtRegisterId.getText().toString();
            String pw = binding.edtRegisterPw.getText().toString();
            boolean isIdNotUsed = true;
            for (UserDTO u : userList) {
                if (u.getId().equals(id)) {
                    isIdNotUsed = false;
                    Toast.makeText(this, "이미 사용중인 아이디입니다", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            boolean check1 = binding.checkRegister1.isChecked();
            boolean check2 = binding.checkRegister2.isChecked();

            if (isIdNotUsed && check1 && check2) {
                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show();
                userList.add(new UserDTO(id, pw, id, R.drawable.profile_img9, new ArrayList<CategoryDTO>(), new ArrayList<UserDTO>()));
                Log.d("userList", userList.size() + "");
                finish();
            }
        });


        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}