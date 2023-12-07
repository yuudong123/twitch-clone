package com.example.and00_twitchclone.main1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemMenu1LiveBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main1LiveAdapter extends RecyclerView.Adapter<Main1LiveAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<UserDTO> list;
    ItemMenu1LiveBinding binding;

    public Main1LiveAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu1LiveBinding.inflate(inflater, parent, false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu1LiveImage.setBackgroundResource(R.drawable.stream_thumbnail);
        holder.binding.menu1LiveViewer.setText(list.get(i).getStreamDTO().getViewerFormat());
        holder.binding.menu1LiveProfile.setImageResource(list.get(i).getImage());
        holder.binding.menu1LiveStreamerName.setText(list.get(i).getNickname());
        holder.binding.menu1LiveTitle.setText(list.get(i).getStreamDTO().getTitle());
        holder.binding.menu1LiveCategory.setText(list.get(i).getStreamDTO().getCategoryDTO().getName());
        holder.binding.menu1LiveBlock.setOnClickListener(v->{
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
        ItemMenu1LiveBinding binding;

        public ViewHolder(ItemMenu1LiveBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
