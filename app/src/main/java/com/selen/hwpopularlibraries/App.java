package com.selen.hwpopularlibraries;

import android.app.Application;

import com.selen.hwpopularlibraries.di.AppComponent;
import com.selen.hwpopularlibraries.di.DaggerAppComponent;
import com.selen.hwpopularlibraries.di.RetrofitNetModule;

public class App extends Application {

    private static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

//        appComponent = DaggerAppComponent.create();
        appComponent = DaggerAppComponent
                .builder()
//                TODO обернуть контекст интерфейсом
                .retrofitNetModule(new RetrofitNetModule(getApplicationContext()))
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}
