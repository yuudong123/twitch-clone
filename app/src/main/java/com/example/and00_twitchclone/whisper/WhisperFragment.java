package com.example.and00_twitchclone.whisper;

import static com.example.and00_twitchclone.CommonVal.userList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and00_twitchclone.MainActivity;
import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.StartActivity;
import com.example.and00_twitchclone.alim.AlimAdapter;
import com.example.and00_twitchclone.alim.AlimDTO;
import com.example.and00_twitchclone.databinding.FragmentWhisperBinding;

import java.util.ArrayList;
import java.util.Date;

public class WhisperFragment extends Fragment {

    FragmentWhisperBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWhisperBinding.inflate(inflater,container,false);

        ArrayList<WhisperDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new WhisperDTO(userList.get(i+10)));
        }
        WhisperAdapter adapter = new WhisperAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.whisperRecv.setAdapter(adapter);
        binding.whisperRecv.setLayoutManager(manager);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding =null;
    }
}