package com.selen.hwpopularlibraries;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainViewModel extends ViewModel {

    private Model model;
    private Observer<String> observer;
    private Disposable disposable;
    public MutableLiveData<String> changeText = new MutableLiveData<>();

    public MainViewModel() {
        model = new Model();
        observerInit();
        model.getObservable().subscribe(observer);
    }

    private void observerInit() {
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                MainViewModel.this.disposable = d;
            }

            @Override
            public void onNext(@NonNull String s) {
                changeText.setValue(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public void setMyText(String text) {
        model.setText(text);
    }
}
