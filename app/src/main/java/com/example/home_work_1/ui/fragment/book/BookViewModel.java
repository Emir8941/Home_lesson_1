package com.example.home_work_1.ui.fragment.book;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.home_work_1.R;
import com.example.home_work_1.model.BookModel;

import java.util.ArrayList;

public class BookViewModel extends ViewModel {
    public MutableLiveData<ArrayList<BookModel>> data = new MutableLiveData<>();
    private MutableLiveData<BookModel> selected = new MutableLiveData<>();
    ArrayList<BookModel> list = new ArrayList<>();

    public void setSelected(BookModel model) {
        selected.setValue(model);
    }

    public MutableLiveData<BookModel> getSelected() {
        return selected;
    }

    public void getList() {
        list.add(new BookModel("Book ", "Book description", R.drawable.ic_book));
        list.add(new BookModel("Book 1", "Book description 1", R.drawable.ic_book));
        list.add(new BookModel("Book 2", "Book description 2", R.drawable.ic_book));
        list.add(new BookModel("Book 3", "Book description 3", R.drawable.ic_book));
        list.add(new BookModel("Book 3", "Book description 4", R.drawable.ic_book));
        data.setValue(list);
    }
}
