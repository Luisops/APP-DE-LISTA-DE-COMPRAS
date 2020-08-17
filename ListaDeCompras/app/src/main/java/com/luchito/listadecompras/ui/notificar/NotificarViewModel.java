package com.luchito.listadecompras.ui.notificar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificarViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public NotificarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("NOTIFICAR");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
