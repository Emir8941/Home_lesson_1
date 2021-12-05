package com.example.home_work_1.ui.fragment.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.home_work_1.databinding.FragmentDetailsBinding;
import com.example.home_work_1.ui.fragment.book.BookViewModel;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        BookViewModel viewModel = new ViewModelProvider(requireActivity()).get(BookViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), firstModel -> {
            binding.bookName.setText(firstModel.getName());
            binding.bookDescription.setText(firstModel.getDescription());
            binding.bookImg.setImageResource(firstModel.getImage());
        });
    }
}