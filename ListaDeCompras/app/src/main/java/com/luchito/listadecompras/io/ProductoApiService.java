package com.luchito.listadecompras.io;

import com.luchito.listadecompras.Model.Produccion;
import com.luchito.listadecompras.Model.ProduccionResponse;
import com.luchito.listadecompras.Model.SuperMercado;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductoApiService {


    @GET("Obtener_Lista.php")
    Call<ArrayList<Produccion>> getDiseases();

    @GET("Obtener_supermercados.php")
    Call<ArrayList<SuperMercado>> getDisseasesSuper();

    @FormUrlEncoded
    @POST("Anadir_producto.php?")
    Call<ProduccionResponse> postProduccion(@Field("Producto")String EstadoCompra,@Field("Supermercado") String Supermercado,@Field("Estadocompra") String Estadocompra);
    //Call<ProduccionResponse> postProduccion(@Field("Producto") String producto, @Field("Supermercado") String supermercado,@Field("Estadocompra") String estadocompra);

}
