package com.example.and00_twitchclone.whisper;

import static com.example.and00_twitchclone.CommonVal.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

import com.example.and00_twitchclone.databinding.ActivityWhisperBinding;

public class WhisperActivity extends AppCompatActivity {

    ActivityWhisperBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWhisperBinding.inflate(getLayoutInflater());
        WhisperDTO dto = (WhisperDTO) getIntent().getSerializableExtra("OtherDTO");

        binding.whisperActivityBtnClose.setOnClickListener(v->{
            finish();
        });
        binding.whisperActivityOtherName.setText(dto.getOther().getNickname());
        binding.whisperActivityChatEdtMsg.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEND) {
                binding.whisperActivityTextBox.append(user.getNickname() + " (" + user.getId() + "): " + binding.whisperActivityChatEdtMsg.getText() + "\n");
                binding.whisperActivityChatEdtMsg.setText("");
            }
            return true;
        });

        setContentView(binding.getRoot());
    }
}