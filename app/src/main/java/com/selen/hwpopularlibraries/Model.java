package com.selen.hwpopularlibraries;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Model {
    private String text;
    private Observable<String> observable;
    private ObservableEmitter<String> emitter;

    public Model() {
        observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                Model.this.emitter = emitter;
            }
        });
//        }).subscribeOn(Schedulers.io());
    }

    public void setText(String text) {
        this.text = text;
        emitter.onNext(text);
    }

    public Observable<String> getObservable() {
        return observable;
    }
}
