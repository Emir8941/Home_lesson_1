package com.example.home_work_1.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_work_1.databinding.ItemTaskBinding;
import com.example.home_work_1.model.BookModel;
import com.example.home_work_1.ui.fragment.onClick.OnItemClick;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    public ArrayList<BookModel> list = new ArrayList<>();
    private OnItemClick itemClick;

    public void setOnItemClick(OnItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setBooks(ArrayList<BookModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemTaskBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemTaskBinding binding;

        public MyViewHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(BookModel model) {
            binding.itemName.setText(model.getName());
            binding.itemImage.setImageResource(model.getImage());
            itemView.setOnClickListener(view -> {
                itemClick.onClick(model);
            });
        }
    }
}
