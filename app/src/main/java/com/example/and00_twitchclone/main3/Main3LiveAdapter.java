package com.example.and00_twitchclone.main3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemMenu2LiveBinding;
import com.example.and00_twitchclone.databinding.ItemMenu3LiveBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main3LiveAdapter extends RecyclerView.Adapter<Main3LiveAdapter.ViewHolder> {
    ItemMenu3LiveBinding binding;
    LayoutInflater inflater;
    ArrayList<UserDTO> list;

    public Main3LiveAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu3LiveBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu3LiveThnail.setImageResource(R.drawable.stream_thumbnail);
        holder.binding.menu3LiveViewer.setText("시청자 "+list.get(i).getStreamDTO().getViewerFormat()+"명");
        holder.binding.menu3LiveTitle.setText(list.get(i).getStreamDTO().getTitle());
        holder.binding.menu3LiveProfile.setImageResource(list.get(i).getImage());
        holder.binding.menu3LiveCategory.setText(list.get(i).getStreamDTO().getCategoryDTO().getName());
        holder.binding.menu3LiveStreamer.setText(list.get(i).getNickname());
        holder.binding.menu3LiveThnail.setOnClickListener(v->{
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
        ItemMenu3LiveBinding binding;
        public ViewHolder(ItemMenu3LiveBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
