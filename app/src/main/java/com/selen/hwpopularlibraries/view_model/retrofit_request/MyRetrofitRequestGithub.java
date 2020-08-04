package com.selen.hwpopularlibraries.view_model.retrofit_request;

import com.selen.hwpopularlibraries.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitRequestGithub {

    private Retrofit retrofit;
    private RestApi restApi;

    public MyRetrofitRequestGithub() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        restApi = retrofit.create(RestApi.class);
    }

    public Single<List<User>> request() {
        return restApi.loadUsers();
    }

}
