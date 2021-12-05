package com.example.home_work_1.ui.fragment.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.home_work_1.R;
import com.example.home_work_1.databinding.FragmentBookBinding;
import com.example.home_work_1.ui.adapter.BookAdapter;

public class BookFragment extends Fragment {

    private FragmentBookBinding binding;
    private BookViewModel viewModel;
    private BookAdapter adapter = new BookAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupAdapter();
        onClick();
        setupObservers();
        detail();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(BookViewModel.class);
    }

    private void setupAdapter() {
        binding.rvTask.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvTask.setAdapter(adapter);
    }

    private void detail() {
        adapter.setOnItemClick(model -> {
            viewModel.setSelected(model);
            BookFragment.this.close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment);
        navController.navigate(R.id.detailsFragment);
    }

    private void setupObservers() {
        viewModel.data.observe(getViewLifecycleOwner(), firstModels -> {
            binding.rvTask.setVisibility(View.VISIBLE);
            adapter.setBooks(firstModels);
            binding.btnFill.setVisibility(View.GONE);
        });
    }

    private void onClick() {
        binding.btnFill.setOnClickListener(v -> {
            viewModel.getList();
            binding.rvTask.setVisibility(View.VISIBLE);
            binding.btnFill.setVisibility(View.GONE);
        });
    }
}