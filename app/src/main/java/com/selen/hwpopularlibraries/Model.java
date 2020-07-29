package com.selen.hwpopularlibraries;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class Model {

    private String result;
    private Observable<Long> firstOb;
    private Observable<Long> secondOb;
    private PublishSubject<Long> thirdOb;


    public Model() {
        result = "";
        firstOb = Observable.interval(1, TimeUnit.SECONDS);
        secondOb = Observable.interval(1, TimeUnit.SECONDS).delay(500,TimeUnit.MILLISECONDS);
        thirdOb = PublishSubject.create();
        firstOb.subscribe(thirdOb);
        secondOb.subscribe(thirdOb);
    }

    public PublishSubject<Long> getThirdOb() {
        return thirdOb;
    }

    public void appendText(String text){
        result+=text;
    }

    public String getResult() {
        return result;
    }
}
