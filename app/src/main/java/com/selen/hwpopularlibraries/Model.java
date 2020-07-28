package com.selen.hwpopularlibraries;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class Model {
    private String text;
    private ConnectableObservable<String> observable;
    private ObservableEmitter<String> emitter;

    public Model() {
        observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Throwable {
                        Log.d("RX", text);
                        return text;
                    }
                }).publish();
        observable.connect();
    }

    public void setText(String text) {
        this.text = text;
    }

    public Observable<String> getObservable() {
        return observable;
    }
}
