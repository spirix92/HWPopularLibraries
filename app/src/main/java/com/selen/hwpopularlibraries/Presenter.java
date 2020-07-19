package com.selen.hwpopularlibraries;

public class Presenter {
    private Model mModel;
    private MainView view;

    public Presenter(MainView view) {
        this.mModel = new Model();
        this.view = view;
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(int btnIndex) {
        int newModelValue;
        newModelValue = calcNewModelValue(btnIndex);
        mModel.setElementValueAtIndex(btnIndex, newModelValue);
        view.setButtonText(btnIndex, newModelValue);
    }

}

