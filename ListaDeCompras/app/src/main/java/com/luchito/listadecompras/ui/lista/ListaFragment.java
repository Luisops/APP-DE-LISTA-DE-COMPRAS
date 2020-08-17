package com.luchito.listadecompras.ui.lista;
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

import com.luchito.listadecompras.Model.Produccion;
import com.luchito.listadecompras.R;
import com.luchito.listadecompras.io.ProductoApiAdapter;
import com.luchito.listadecompras.ui.adapter.DiseasAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFragment extends Fragment implements Callback<ArrayList<Produccion>> {

    private DiseasAdapter mAdapter;
    private ListaViewModel listaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listaViewModel = ViewModelProviders.of(this).get(ListaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nav_listar_compras, container, false);
        //final TextView textView = root.findViewById(R.id.jsonText);

        RecyclerView mRecyclerView = (RecyclerView)root.findViewById(R.id.recyclerView_lista_de_compras);

        //findViewById(R.id.recyclerView);recyclerView

        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager -GridLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)
         mAdapter = new DiseasAdapter();
        mRecyclerView.setAdapter(mAdapter);

        Call<ArrayList<Produccion>> call = ProductoApiAdapter.getApiService().getDiseases();
        call.enqueue(this);

       /* listaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }


        });

        */
        return root;
    }

    @Override
    public void onResponse(Call<ArrayList<Produccion>> call, Response<ArrayList<Produccion>> response) {
        if (response.isSuccessful()){
            ArrayList<Produccion> produccion = response.body();
            Log.d("onResponse diseases", "Sise of diseases => "+ produccion.size());

            mAdapter.setmDataSet(produccion);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Produccion>> call, Throwable t) {

    }
}
