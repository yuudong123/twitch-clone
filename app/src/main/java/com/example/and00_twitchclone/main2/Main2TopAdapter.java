package com.example.and00_twitchclone.main2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemMenu2TopBinding;
import com.example.and00_twitchclone.domain.UserDTO;
import com.example.and00_twitchclone.watch.WatchActivity;

import java.util.ArrayList;

public class Main2TopAdapter extends RecyclerView.Adapter<Main2TopAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<UserDTO> list;
    ItemMenu2TopBinding binding;
    public static final int MAX_VALUE = 1000000;

    public Main2TopAdapter(LayoutInflater inflater, ArrayList<UserDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu2TopBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Main2TopAdapter.ViewHolder holder, int position) {
        int i = getActualPosition(position);
        holder.binding.menu2TopThnail.setImageResource(R.drawable.stream_thumbnail);
        holder.binding.menu2TopViewer.setText("시청자 "+list.get(i).getStreamDTO().getViewerFormat()+"명");
        holder.binding.menu2TopThnail.setOnClickListener(v->{
            Intent intent = new Intent(inflater.getContext(), WatchActivity.class);
            intent.putExtra("Streamer",list.get(i));
            inflater.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return MAX_VALUE;
    }

    private int getActualPosition(int position) {
        return position % list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu2TopBinding binding;
        public ViewHolder(ItemMenu2TopBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
