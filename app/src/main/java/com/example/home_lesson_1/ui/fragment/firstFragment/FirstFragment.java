package com.example.home_lesson_1.ui.fragment.firstFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.home_lesson_1.R;
import com.example.home_lesson_1.databinding.FragmentFirstBinding;
import com.example.home_lesson_1.model.FirstModel;
import com.example.home_lesson_1.ui.adapter.FirstFragmentAdapter;
import com.example.home_lesson_1.ui.fragment.onClick.OnItemClick;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private FirstViewModel viewModel;
    private FirstFragmentAdapter adapter = new FirstFragmentAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAlysetion();
        initRV();
        onClick();
        setUpObserve();
        detail();
    }

    private void detail() {
        adapter.setOnItemClick(model -> {
            FirstViewModel viewModel = new ViewModelProvider(FirstFragment.this.requireActivity())
                    .get(FirstViewModel.class);
            viewModel.setSelected(model);
            FirstFragment.this.close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment);
        navController.navigate(R.id.detailsFragment);
    }

    private void setUpObserve() {
        viewModel.data.observe(getViewLifecycleOwner(), firstModels -> {
            binding.rV.setVisibility(View.VISIBLE);
            adapter.setBooks(firstModels);
            binding.button.setVisibility(View.GONE);
            Log.e("anime", "onChanged: ");
        });
    }

    private void onClick() {
        binding.button.setOnClickListener(v -> {
            viewModel.getList();
            binding.rV.setVisibility(View.VISIBLE);
            binding.button.setVisibility(View.GONE);
            Log.e("anime", "onClick: " );
        });
    }

    private void initRV() {
        set();
    }

    private void set() {
        binding.rV.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rV.setAdapter(adapter);
    }

    private void initAlysetion() {
        viewModel = new ViewModelProvider(requireActivity()).get(FirstViewModel.class);
    }
}