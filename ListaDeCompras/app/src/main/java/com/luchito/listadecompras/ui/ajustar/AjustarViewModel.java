package com.luchito.listadecompras.ui.ajustar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AjustarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AjustarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("PREFERENCIAS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
