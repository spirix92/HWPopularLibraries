package com.selen.hwpopularlibraries.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.selen.hwpopularlibraries.App;
import com.selen.hwpopularlibraries.model.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    @Inject
    Single<List<User>> single;
    public MutableLiveData<List<User>> request = new MutableLiveData<>();

    public MainViewModel() {
        App.getAppComponent().injectsToMainViewModel(this);
    }

    public void requestAll() {
        single.subscribeOn(Schedulers.io())
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
