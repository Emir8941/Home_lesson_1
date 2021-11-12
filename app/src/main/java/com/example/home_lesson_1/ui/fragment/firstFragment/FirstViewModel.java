package com.example.home_lesson_1.ui.fragment.firstFragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.home_lesson_1.R;
import com.example.home_lesson_1.model.FirstModel;

import java.util.ArrayList;

public class FirstViewModel extends ViewModel {
    public MutableLiveData<ArrayList<FirstModel>> data = new MutableLiveData<>();
    private MutableLiveData<FirstModel> selected = new MutableLiveData<>();
    ArrayList<FirstModel> list = new ArrayList<>();

    public void setSelected(FirstModel model){
        selected.setValue(model);
    }

    public MutableLiveData<FirstModel> getSelected(){
        return selected;
    }

    public void getList(){
        list.add(new FirstModel("Мегумин", "Мегумин (め ぐ み ん) - Верховный Волшебник из Клана Багровых Демонов в Фэнтезийном мире и первый человек, присоединившийся к партии Кадзумы . Она - один из главных героев сериала « КоноСуба ».", R.drawable.megumin));
        list.add(new FirstModel("Сато Казума", "Сато Казума (佐藤さ と う 和 真か ず ま) (фамилия Сато, имя Казума) - главный герой сериала КоноСуба . После смерти он перевоплотился в мир фантазий.", R.drawable.kazuma));
        list.add(new FirstModel("Аква", "Аква (ア ク ア, Акуа ) - один из трех главных дейтерагонистов в серии КоноСуба . До жизни в мире фантазий она была богиней воды, которая вела людей в загробную жизнь; внутри ей поклоняется Орден Оси .", R.drawable.aqua));
        list.add(new FirstModel("Дастинс Форд Лалатина", "Дастинс Форд Лалатина (ダ ス テ ィ ネ ス ・ フ ォ ー ド ・ ラ ラ テ ィ ー ナ), обычно известная как Тьма (ダ ク ネ ス), является одной из трех главных героинь сериала « КоноСуба ». Она - крестоносец с мазохистскими наклонностями, присоединившаяся к партии Кадзумы .", R.drawable.darkness));
        list.add(new FirstModel("Юньюн", "Юньюн (ゆ ん ゆ ん) - персонаж сериала КоноСуба . Она член и будущий глава Клана Багровых Демонов , а также друг и самопровозглашенный соперник Мегумин .", R.drawable.yunyun));
        data.setValue(list);
    }
}
