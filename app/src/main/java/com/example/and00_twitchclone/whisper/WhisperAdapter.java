package com.example.and00_twitchclone.whisper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.databinding.ItemWhisperBinding;

import java.util.ArrayList;

public class WhisperAdapter extends RecyclerView.Adapter<WhisperAdapter.ViewHolder> {
    ItemWhisperBinding binding;
    Context context;
    ArrayList<WhisperDTO> list;

    public WhisperAdapter(ArrayList<WhisperDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemWhisperBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.whisperItemProfile.setImageResource(list.get(i).getOther().getImage());
        holder.binding.whisperItemOtherName.setText(list.get(i).getOther().getNickname());
        holder.binding.whisperItemLastMsg.setText(list.get(i).getHistory().size() != 0 ? list.get(i).getHistory().get(list.get(i).getHistory().size() - 1) : "");
        holder.binding.whisperItemBlock.setOnClickListener(v -> {
            Intent intent = new Intent(context, WhisperActivity.class);
            intent.putExtra("OtherDTO", list.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemWhisperBinding binding;

        public ViewHolder(ItemWhisperBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
