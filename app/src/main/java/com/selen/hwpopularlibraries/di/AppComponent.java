package com.selen.hwpopularlibraries.di;

import com.selen.hwpopularlibraries.view_model.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RetrofitNetModule.class)
public interface AppComponent {
void injectsToMainViewModel(MainViewModel mainViewModel);
}
