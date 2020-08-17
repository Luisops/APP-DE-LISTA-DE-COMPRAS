package com.luchito.listadecompras.ui.informar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformarViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public InformarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(
                "LUIS FERNANDO MUÑOZ GUERRA\n" +
                "PAUL OJEDA QUISPE\n" +
                "ROJAS ESPINOZA MORGAN\n" +
                "LUIS ORBEGOSO JUMO\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
