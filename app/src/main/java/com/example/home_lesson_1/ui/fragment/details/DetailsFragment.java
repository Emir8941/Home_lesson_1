package com.example.home_lesson_1.ui.fragment.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.home_lesson_1.databinding.FragmentDetailsBinding;
import com.example.home_lesson_1.model.FirstModel;
import com.example.home_lesson_1.ui.fragment.firstFragment.FirstViewModel;

public class DetailsFragment extends Fragment {

    FragmentDetailsBinding binding;
    ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initTitle();
    }

    private void initTitle() {
        getParentFragmentManager().setFragmentResultListener("key2", getViewLifecycleOwner(), (requestKey, result) -> {
            FirstModel model = (FirstModel) result.getSerializable("key");
            binding.taskIm.setImageResource(model.getImage());
            binding.name.setText(model.getName());
            binding.lor.setText(model.getDescription());
        });
    }

    private void initView() {
        viewModel = new ViewModelProvider(requireActivity()).get(FirstViewModel.class);
    }
}