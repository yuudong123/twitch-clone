package com.example.and00_twitchclone;

import static com.example.and00_twitchclone.CommonVal.userList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.and00_twitchclone.databinding.ActivityLoginBinding;
import com.example.and00_twitchclone.domain.UserDTO;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        binding.btnLoginSubmit.setOnClickListener(v -> {
            String id = binding.edtLoginId.getText().toString();
            String pw = binding.edtLoginPw.getText().toString();

            for (UserDTO u : userList) {
                if (u.getId().equals(id) && u.getPassword().equals(pw)) {
                    Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                    intent.putExtra("isLoginSuccess", "success");
                    intent.putExtra("loginUser", u);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
            Toast.makeText(this, "입력 정보를 확인하세요", Toast.LENGTH_SHORT).show();
        });

        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}