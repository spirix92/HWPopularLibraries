package com.selen.hwpopularlibraries;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;


public class Model {
    private String text;
    private ConnectableObservable<String> observable;

    public Model() {
        observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return Model.this.text;
//                        return Model.this.text; - не работает
//                        return text; - не работает
//                        return "случайный текст"; - работает
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
