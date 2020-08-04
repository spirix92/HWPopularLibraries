package com.selen.hwpopularlibraries.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.selen.hwpopularlibraries.model.MainModel;
import com.selen.hwpopularlibraries.model.User;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private MainModel model;
    public MutableLiveData<List<User>> request = new MutableLiveData<>();

    public MainViewModel() {
        model = new MainModel();
    }

    public void requestAll() {
        model.requestAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<User>>() {

            @Override
            public void onSuccess(List<User> users) {
                MainViewModel.this.request.postValue(users);
            }

            @Override
            public void onError(Throwable e) {
                MainViewModel.this.request.postValue(null);
            }
        });
    }

}
