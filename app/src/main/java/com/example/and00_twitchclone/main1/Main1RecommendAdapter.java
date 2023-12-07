package com.example.and00_twitchclone.main1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemMenu1RecommendBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main1RecommendAdapter extends RecyclerView.Adapter<Main1RecommendAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<UserDTO> list;
    ItemMenu1RecommendBinding binding;

    public Main1RecommendAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu1RecommendBinding.inflate(inflater, parent, false);
        ViewHolder holder = new ViewHolder(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu1RecommendImage.setBackgroundResource(R.drawable.stream_thumbnail);
        holder.binding.menu1RecommendViewer.setText(list.get(i).getStreamDTO().getViewerFormat());
        holder.binding.menu1RecommendProfile.setImageResource(list.get(i).getImage());
        holder.binding.menu1RecommendStreamerName.setText(list.get(i).getNickname());
        holder.binding.menu1RecommendTitle.setText(list.get(i).getStreamDTO().getTitle());
        holder.binding.menu1RecommendBlock.setOnClickListener(v->{
            Intent intent = new Intent(inflater.getContext(), WatchActivity.class);
            intent.putExtra("Streamer",list.get(i));
            inflater.getContext().startActivity(intent);
        });
        holder.binding.menu1RecommendCategory.setText(list.get(i).getStreamDTO().getCategoryDTO().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu1RecommendBinding binding;

        public ViewHolder(ItemMenu1RecommendBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
