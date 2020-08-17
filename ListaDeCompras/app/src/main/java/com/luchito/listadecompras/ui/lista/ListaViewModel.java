package com.luchito.listadecompras.ui.lista;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ListaViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public ListaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("AQUI SE AGREGARA LAS LISTA DE PRODUCTOS");

    }

    public LiveData<String> getText() {
        return mText;
    }


}
