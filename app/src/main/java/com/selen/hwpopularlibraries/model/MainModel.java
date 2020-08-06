package com.selen.hwpopularlibraries.model;

import com.selen.hwpopularlibraries.view_model.retrofit_request.MyRetrofitRequestGithub;

import java.util.List;

import io.reactivex.Single;

public class MainModel {
    private List<User> users;
    private MyRetrofitRequestGithub retrofit;

    public MainModel() {
        retrofit = new MyRetrofitRequestGithub();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Single<List<User>> requestAllUsers() {
        return retrofit.request();
    }

}
