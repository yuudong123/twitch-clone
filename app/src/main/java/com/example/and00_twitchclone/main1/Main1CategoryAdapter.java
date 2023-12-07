package com.example.and00_twitchclone.main1;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMenu1CategoryBinding;
import com.example.and00_twitchclone.domain.CategoryDTO;

import java.util.ArrayList;

public class Main1CategoryAdapter extends RecyclerView.Adapter<Main1CategoryAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<CategoryDTO> list;
    ItemMenu1CategoryBinding binding;

    public Main1CategoryAdapter(LayoutInflater inflater, ArrayList<CategoryDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMenu1CategoryBinding.inflate(inflater, parent, false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.menu1CategoryImage.setImageResource(list.get(i).getImage());
        holder.binding.menu1CategoryName.setText(list.get(i).getName());
        holder.binding.menu1CategoryViewer.setText(list.get(i).getViewerFormat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemMenu1CategoryBinding binding;

        public ViewHolder(ItemMenu1CategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
