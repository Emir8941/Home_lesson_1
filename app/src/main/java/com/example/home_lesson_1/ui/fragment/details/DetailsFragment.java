package com.example.home_lesson_1.ui.fragment.details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.home_lesson_1.databinding.FragmentDetailsBinding;
import com.example.home_lesson_1.model.FirstModel;
import com.example.home_lesson_1.ui.fragment.firstFragment.FirstViewModel;

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
        initTitle();
    }

    private void initTitle() {
        FirstViewModel viewModel = new ViewModelProvider(requireActivity()).get(FirstViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), firstModel -> {
            binding.name.setText(firstModel.getName());
            binding.lor.setText(firstModel.getDescription());
            binding.taskIm.setImageResource(firstModel.getImage());
        });
    }
}