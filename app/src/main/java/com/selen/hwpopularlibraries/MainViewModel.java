package com.selen.hwpopularlibraries;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private Model model;
    public MutableLiveData<String> changeText = new MutableLiveData<>();

    public MainViewModel() {
        model = new Model();
    }

    public void setText(String text) {
        model.setText(text);
        changeText.setValue(model.getText());
    }
}
