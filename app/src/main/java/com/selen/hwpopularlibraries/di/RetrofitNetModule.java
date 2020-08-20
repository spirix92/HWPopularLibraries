package com.selen.hwpopularlibraries.di;

import android.content.Context;

import com.selen.hwpopularlibraries.model.User;
import com.selen.hwpopularlibraries.view_model.retrofit_request.RestApi;

import java.util.List;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitNetModule {

    //    TODO разобраться с возможными утечками памяти
    private Context context;

    @Provides
    @Singleton
    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    RestApi getRestApi(Retrofit retrofit) {
        RestApi restAPI = retrofit.create(RestApi.class);
        return restAPI;
    }

    @Provides
    Single<List<User>> getSingle(RestApi restAPI) {
        Single<List<User>> single = restAPI.loadUsers();
        return single;
    }

    public RetrofitNetModule(Context context) {
        this.context = context;
    }

}
