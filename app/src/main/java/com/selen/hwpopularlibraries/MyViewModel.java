package com.selen.hwpopularlibraries;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class MyViewModel extends ViewModel {

    private Model model;
    public MutableLiveData<String> third = new MutableLiveData<>();
    public Observer<Long> observer;
    public PublishSubject<Long> thirdOb;


    public MyViewModel() {
        model = new Model();
        initObserver();
        thirdOb = model.getThirdOb();
        thirdOb.observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    private void initObserver() {
        observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                model.appendText(aLong.toString());
                third.setValue(model.getResult());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    public void addText(Long number) {
        thirdOb.onNext(number);
    }

}
