package com.selen.hwpopularlibraries;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;

public class Model {
    private String text = "";
    private ConnectableObservable<String> observable;

    public Model() {
        observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return Model.this.text;
                    }
                })
                .publish();
        observable.connect();
    }

    public void setText(String text) {
        this.text = text;
    }

    public Observable<String> getObservable() {
        return observable;
    }
}
