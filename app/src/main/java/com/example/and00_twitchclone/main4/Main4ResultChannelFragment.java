package com.example.and00_twitchclone.main4;

import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultCategoryBinding;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultChannelBinding;
import com.example.and00_twitchclone.databinding.FragmentMain4ResultVideoBinding;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;

public class Main4ResultChannelFragment extends Fragment {
    FragmentMain4ResultChannelBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMain4ResultChannelBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        ArrayList<UserDTO> channelList = new ArrayList<>();
        for (UserDTO u : userList) {
            if (u.getNickname().contains(Main4Fragment.keyword) || u.getId().contains(Main4Fragment.keyword)) {
                channelList.add(u);
            }
        }

        Main4ResultChannelAdapter adapter = new Main4ResultChannelAdapter(channelList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.main4RecvChannel.setAdapter(adapter);
        binding.main4RecvChannel.setLayoutManager(manager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}