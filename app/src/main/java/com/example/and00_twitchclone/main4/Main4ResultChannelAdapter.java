package com.example.and00_twitchclone.main4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMenu4ChannelBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main4ResultChannelAdapter extends RecyclerView.Adapter<Main4ResultChannelAdapter.ViewHolder> {
    ItemMenu4ChannelBinding binding;
    ArrayList<UserDTO> list;

    public Main4ResultChannelAdapter(ArrayList<UserDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu4ChannelBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.menu4ResultChannelImage.setImageResource(list.get(position).getImage());
        holder.binding.menu4ResultChannelNicknameId.setText(list.get(position).getNickname() + " (" + list.get(position).getId() + ")");
        holder.binding.menu4ResultChannelFollower.setText("팔로워 " + list.get(position).getFollowerFormat() + "명");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemMenu4ChannelBinding binding;

        public ViewHolder(ItemMenu4ChannelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
