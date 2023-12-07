package com.example.and00_twitchclone.main1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.channel.ChannelActivity;
import com.example.and00_twitchclone.databinding.ItemMenu1OfflineBinding;
import com.example.and00_twitchclone.domain.UserDTO;

import java.util.ArrayList;

public class Main1OfflineAdapter extends RecyclerView.Adapter<Main1OfflineAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<UserDTO> list;
    ItemMenu1OfflineBinding binding;

    public Main1OfflineAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemMenu1OfflineBinding.inflate(inflater,parent,false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu1OfflineImage.setImageResource(list.get(i).getImage());
        holder.binding.menu1OfflineNickname.setText(list.get(i).getNickname());
        holder.binding.menu1OfflineId.setText(" ("+list.get(i).getId()+")");
        holder.binding.menu1OfflineBlock.setOnClickListener(v->{
            Intent intent = new Intent(inflater.getContext(),ChannelActivity.class);
            intent.putExtra("UserDTO", list.get(i));
            inflater.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu1OfflineBinding binding;
        public ViewHolder(ItemMenu1OfflineBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
