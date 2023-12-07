package com.example.and00_twitchclone.main4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMenu4CategoryBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;

import java.util.ArrayList;

public class Main4ResultCategoryAdapter extends RecyclerView.Adapter<Main4ResultCategoryAdapter.ViewHolder> {
    ItemMenu4CategoryBinding binding;
    ArrayList<CategoryDTO> list;

    public Main4ResultCategoryAdapter(ArrayList<CategoryDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu4CategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.main4IngiCategoryImage.setImageResource(list.get(position).getImage());
        holder.binding.main4IngiCategoryName.setText(list.get(position).getName());
        holder.binding.main4IngiCategoryViewer.setText(list.get(position).getViewerFormat() + "명");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMenu4CategoryBinding binding;
        public ViewHolder(ItemMenu4CategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
