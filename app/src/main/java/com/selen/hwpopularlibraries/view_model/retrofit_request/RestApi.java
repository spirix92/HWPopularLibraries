package com.selen.hwpopularlibraries.view_model.retrofit_request;

import com.selen.hwpopularlibraries.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RestApi {
    @GET("users")
    Single<List<User>> loadUsers();
}
