package com.luchito.listadecompras.ui.registrar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.luchito.listadecompras.Model.Produccion;
import com.luchito.listadecompras.Model.ProduccionResponse;
import com.luchito.listadecompras.R;
import com.luchito.listadecompras.io.ProductoApiAdapter;
import com.luchito.listadecompras.io.ProductoApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarFragment extends Fragment {
    private RegistrarViewModel registrarViewModel;
    EditText eproducto, esupermercado, econdicion;
    String produc,merc,cond;
    Button btnAgrgar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registrarViewModel = ViewModelProviders.of(this).get(RegistrarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registrar, container, false);
                eproducto = root.findViewById(R.id.editTextProducto);
                esupermercado = root.findViewById(R.id.editTextSuperMercado);
                econdicion = root.findViewById(R.id.editTextCondicion);
                btnAgrgar=root.findViewById(R.id.PostButton);

                btnAgrgar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        postProduccion();
                    }
                });

        return root;
    }
    public Produccion createProducion(){
        Produccion produccion = new Produccion();
        produccion.setProducto(eproducto.getText().toString());
        produccion.setSupermercado(esupermercado.getText().toString());
        produccion.setEstadoCompra(econdicion.getText().toString());

        return produccion;
    }


    public void postProduccion() {

      //  Retrofit retrofit = new Retrofit.Builder().baseUrl("https://paulojedaquispe.com")
          //      .addConverterFactory(GsonConverterFactory.create())
        //        .build();
       // ProductoApiService productoApiService = retrofit.create(ProductoApiService.class);

      //  Produccion produccion = new Produccion(produc,merc,cond);
        Call<ProduccionResponse> call = ProductoApiAdapter.getApiService().postProduccion("producto","supermercado","estadoCompra");
        call.enqueue(new Callback<ProduccionResponse>() {
            @Override
            public void onResponse(Call<ProduccionResponse> call, Response<ProduccionResponse> response) {
              if(response.isSuccessful()) {
                  Toast.makeText(getContext(), "GUARDADO", Toast.LENGTH_LONG).show();
              }else {
                  Toast.makeText(getContext(), "Respuesta fallida", Toast.LENGTH_LONG).show();
              }
            }

            @Override
            public void onFailure(Call<ProduccionResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Respuesta fallida"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}
