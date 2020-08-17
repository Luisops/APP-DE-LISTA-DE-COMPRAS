package com.luchito.listadecompras.ui.ajustar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luchito.listadecompras.Model.SuperMercado;
import com.luchito.listadecompras.R;
import com.luchito.listadecompras.io.ProductoApiAdapter;
import com.luchito.listadecompras.ui.adapter.DiseasAdapter;
import com.luchito.listadecompras.ui.adapter.DiseasAdapterSMercado;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjustarFragment extends Fragment implements Callback<ArrayList<SuperMercado>> {

    private DiseasAdapterSMercado mpAdapter;
    private AjustarViewModel ajustarViewModel;
  //Muestra el contenido del modulo de ajustar llamando ajustar ViewModel
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ajustarViewModel = ViewModelProviders.of(this).get(AjustarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ajustar, container, false);

        RecyclerView mpRecyclerView = (RecyclerView)root.findViewById(R.id.recyclerView_lista_de_SuperMercados);

        mpRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mpRecyclerView.setLayoutManager(layoutManager);


        mpAdapter = new DiseasAdapterSMercado();
        mpRecyclerView.setAdapter(mpAdapter);
        Call<ArrayList<SuperMercado>> call = ProductoApiAdapter.getApiService().getDisseasesSuper();
        call.enqueue(this);
        return root;
    }

    @Override
    public void onResponse(Call<ArrayList<SuperMercado>> call, Response<ArrayList<SuperMercado>> response) {
        if (response.isSuccessful()){
            ArrayList<SuperMercado> superMercados = response.body();
            Log.d("onResponse diseases", "Sise of diseases => "+ superMercados.size());

            mpAdapter.setmDataSet(superMercados);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<SuperMercado>> call, Throwable t) {

    }
}
