package com.example.and00_twitchclone.watch;

import static com.example.and00_twitchclone.CommonVal.user;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ActivityWatchBinding;
import com.example.and00_twitchclone.domain.UserDTO;

public class WatchActivity extends AppCompatActivity {

    ActivityWatchBinding binding;
    boolean play = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        binding = ActivityWatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserDTO streamer = (UserDTO) getIntent().getSerializableExtra("Streamer");
        binding.watchStreamerName.setText(streamer.getNickname());
        binding.watchStreamTitle.setText(streamer.getStreamDTO().getTitle());
        binding.watchStreamCategory.setText(streamer.getStreamDTO().getCategoryDTO().getName());
        binding.watchViewer.setText(streamer.getStreamDTO().getViewer() + "");
        binding.watchPlayPause.setOnClickListener(v -> {
            if (play) {
                binding.watchPlayPause.setImageResource(R.drawable.play);
                play = !play;
            } else {
                binding.watchPlayPause.setImageResource(R.drawable.pause);
                play = !play;
            }
        });
        binding.watchStreamView.setOnClickListener(v -> {
            binding.watchTouchedScreen.setVisibility(View.VISIBLE);
            binding.watchTouchedMenu.setVisibility(View.VISIBLE);
        });
        binding.watchTouchedScreen.setOnClickListener(v -> {
            binding.watchTouchedScreen.setVisibility(View.GONE);
            binding.watchTouchedMenu.setVisibility(View.GONE);
        });
        if (user.getFlwStreamer().contains(streamer)) {
            binding.watchFlwIcon.setImageResource(R.drawable.icon_followed);
        }
        if (user.getAlimStreamer().contains(streamer)) {
            binding.watchAlimIcon.setImageResource(R.drawable.alim_on_icon);
        }
        binding.watchFlw.setOnClickListener(v -> {
            if (user.getFlwStreamer().contains(streamer)) {
                user.getFlwStreamer().remove(streamer);
                binding.watchFlwIcon.setImageResource(R.drawable.icon_menu1);
            } else {
                user.getFlwStreamer().add(streamer);
                binding.watchFlwIcon.setImageResource(R.drawable.icon_followed);
            }
        });
        binding.watchAlim.setOnClickListener(v -> {
            if (user.getAlimStreamer().contains(streamer)) {
                user.getAlimStreamer().remove(streamer);
                binding.watchAlimIcon.setImageResource(R.drawable.alim_off_icon);
            } else {
                user.getAlimStreamer().add(streamer);
                binding.watchAlimIcon.setImageResource(R.drawable.alim_on_icon);
            }
        });
        binding.watchSubscribe.setOnClickListener(v -> {
            Toast.makeText(this, "결제 기능", Toast.LENGTH_SHORT).show();
        });
        binding.watchSubscribe2.setOnClickListener(v -> {
            Toast.makeText(this, "결제 기능", Toast.LENGTH_SHORT).show();
        });
        binding.watchShare.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String text="twitch.tv/"+streamer.getId();
            intent.putExtra(Intent.EXTRA_TEXT, text);
            Intent shareIntent = Intent.createChooser(intent, "공유하기");
            startActivity(shareIntent);
        });
        binding.watchClip.setOnClickListener(v -> {
            Toast.makeText(this, "해당 국가에서 사용할 수 없는 기능입니다.", Toast.LENGTH_SHORT).show();
        });
        binding.watchChat.setVisibility(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE ? View.VISIBLE : View.GONE);
        binding.watchRotate.setOnClickListener(v -> {
            if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });

        binding.watchChatEdtMsg.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEND) {
                binding.watchChatMsg.append(user.getNickname() + " (" + user.getId() + "): " + binding.watchChatEdtMsg.getText() + "\n");
                binding.watchChatEdtMsg.setText("");
            }
            return true;
        });
    }
}