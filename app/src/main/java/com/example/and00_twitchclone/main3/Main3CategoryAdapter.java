package com.example.and00_twitchclone.main3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMenu3CategoryBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;

import java.util.ArrayList;

public class Main3CategoryAdapter extends RecyclerView.Adapter<Main3CategoryAdapter.ViewHolder> {
    ItemMenu3CategoryBinding binding;
    ArrayList<CategoryDTO> list;

    public Main3CategoryAdapter(ArrayList<CategoryDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu3CategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.main3CategoryImage.setImageResource(list.get(position).getImage());
        holder.binding.main3CategoryName.setText(list.get(position).getName());
        holder.binding.main3CategoryViewer.setText("시청자 "+list.get(position).getViewerFormat()+"명");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu3CategoryBinding binding;
        public ViewHolder(ItemMenu3CategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
