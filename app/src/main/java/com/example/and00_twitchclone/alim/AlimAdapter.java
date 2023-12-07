package com.example.and00_twitchclone.alim;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and00_twitchclone.R;
import com.example.and00_twitchclone.databinding.ItemAlimBinding;

import java.util.ArrayList;

public class AlimAdapter extends RecyclerView.Adapter<AlimAdapter.ViewHolder> {

    ItemAlimBinding binding;
    ArrayList<AlimDTO> list;

    public AlimAdapter(ArrayList<AlimDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemAlimBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        AlimDTO dto = list.get(i);
        holder.binding.alimItemContent.setText("이제"+dto.getCategory()+"의"+dto.getDropName()+"을(를) 받을 수 있습니다.. 전리품을 받으려면 "+dto.getUntilDate()+"까지 인벤토리 페이지에서 드롭을 받으세요!");
        holder.binding.alimItemDate.setText(dto.getSendDate());
        holder.binding.alimItemImage.setImageResource(dto.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemAlimBinding binding;

        public ViewHolder(ItemAlimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
