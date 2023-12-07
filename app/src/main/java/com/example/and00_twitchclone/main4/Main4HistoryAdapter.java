package com.example.and00_twitchclone.main4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemMain4SearchHistoryBinding;

public class Main4HistoryAdapter extends RecyclerView.Adapter<Main4HistoryAdapter.ViewHolder> {

    ItemMain4SearchHistoryBinding binding;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMain4SearchHistoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.main4ItemHistoryText.setText(Main4Fragment.searchHistory.get(position));
        holder.binding.main4ItemHistoryRemoveBtn.setOnClickListener(v -> {
            Main4Fragment.searchHistory.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
    }

    @Override
    public int getItemCount() {
        return Main4Fragment.searchHistory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemMain4SearchHistoryBinding binding;

        public ViewHolder(ItemMain4SearchHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
