    package com.example.home_lesson_1.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.home_lesson_1.R;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

//- Создать Fragment в котором будет, кнопочка "Заполнить" и Recycler.
//- При нажатии на кнопку:
//   - он исчезает
//   - обращается к методы в viewModel, этот метод сетит данные из Client'a в LiveData'у
//   - В Fragment'e вы observe'ите данные и отображаете в recycler
//- При нажатии на item нужно открыть детальный Fragment, этого item'a
//
//Обязательно:
//- Используйте Navigation components (NavController)
//- ViewModel
//- LiveData