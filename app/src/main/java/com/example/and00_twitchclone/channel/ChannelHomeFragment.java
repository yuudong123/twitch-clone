package com.example.and00_twitchclone.channel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.FragmentChannelHomeBinding;
import com.example.and00_twitchclone.domain.UserDTO;

public class ChannelHomeFragment extends Fragment {

    FragmentChannelHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelHomeBinding.inflate(inflater, container, false);

        UserDTO user = (UserDTO) getArguments().getSerializable("UserDTO");
        if (user.getStreamDTO().isLive()) {
            binding.channelHomeLive.setVisibility(View.VISIBLE);
            binding.channelHomeNull.setVisibility(View.GONE);
            binding.channelHomeLiveThumbnail.setImageResource(R.drawable.stream_thumbnail);
            binding.channelHomeLiveTitle.setText(user.getStreamDTO().getTitle());
            binding.channelHomeLiveCategory.setText(user.getStreamDTO().getCategoryDTO().getName());
            binding.channelHomeLiveViewer.setText("시청자 " + user.getStreamDTO().getViewerFormat() +"명");
        } else {
            binding.channelHomeLive.setVisibility(View.GONE);
            binding.channelHomeNull.setVisibility(View.VISIBLE);
        }
        return binding.getRoot();
    }
}