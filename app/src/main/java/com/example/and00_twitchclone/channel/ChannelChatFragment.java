package com.example.and00_twitchclone.channel;

import static com.example.and00_twitchclone.CommonVal.user;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.databinding.FragmentChannelChatBinding;

public class ChannelChatFragment extends Fragment {

    FragmentChannelChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelChatBinding.inflate(inflater, container, false);

        binding.activityChannelChatEdtMsg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEND) {
                    binding.activityChannelChatMsg.append(user.getNickname()+" ("+user.getId()+"): "+binding.activityChannelChatEdtMsg.getText()+"\n");
                    binding.activityChannelChatEdtMsg.setText("");
                }
                return true;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}