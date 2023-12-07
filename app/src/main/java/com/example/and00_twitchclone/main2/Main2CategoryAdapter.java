package com.example.and00_twitchclone.main2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMenu2CategoryBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;

import java.util.ArrayList;

public class Main2CategoryAdapter extends RecyclerView.Adapter<Main2CategoryAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<CategoryDTO> list;
    ItemMenu2CategoryBinding binding;

    public Main2CategoryAdapter(LayoutInflater inflater, ArrayList<CategoryDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu2CategoryBinding.inflate(inflater, parent, false);
        ViewHolder holder = new Main2CategoryAdapter.ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Main2CategoryAdapter.ViewHolder holder, int i) {
        holder.binding.menu2CategoryImage.setImageResource(list.get(i).getImage());
        holder.binding.menu2CategoryName.setText(list.get(i).getName());
        holder.binding.menu2CategoryViewer.setText("시청자 "+list.get(i).getViewerFormat()+"명");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemMenu2CategoryBinding binding;

        public ViewHolder(ItemMenu2CategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
