package com.example.and00_twitchclone.main2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemMenu2LiveBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main2LiveAdapter extends RecyclerView.Adapter<Main2LiveAdapter.ViewHolder> {
    ItemMenu2LiveBinding binding;
    LayoutInflater inflater;
    ArrayList<UserDTO> list;

    public Main2LiveAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu2LiveBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu2LiveThnail.setImageResource(R.drawable.stream_thumbnail);
        holder.binding.menu2LiveViewer.setText("시청자 "+list.get(i).getStreamDTO().getViewerFormat()+"명");
        holder.binding.menu2LiveTitle.setText(list.get(i).getStreamDTO().getTitle());
        holder.binding.menu2LiveProfile.setImageResource(list.get(i).getImage());
        holder.binding.menu2LiveCategory.setText(list.get(i).getStreamDTO().getCategoryDTO().getName());
        holder.binding.menu2LiveStreamer.setText(list.get(i).getNickname());
        holder.binding.menu2LiveThnail.setOnClickListener(v->{
            Intent intent = new Intent(inflater.getContext(), WatchActivity.class);
            intent.putExtra("Streamer",list.get(i));
            inflater.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu2LiveBinding binding;
        public ViewHolder(ItemMenu2LiveBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
