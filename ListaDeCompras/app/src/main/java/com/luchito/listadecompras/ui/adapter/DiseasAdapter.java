package com.luchito.listadecompras.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.luchito.listadecompras.Model.Produccion;
import com.luchito.listadecompras.R;

import java.util.ArrayList;

public class DiseasAdapter extends RecyclerView.Adapter<DiseasAdapter.ViewHolder>{
    private ArrayList<Produccion> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;

        public ViewHolder(View tv) {
            super(tv);
            textView1 = tv.findViewById(R.id.textView3);
            textView2 = tv.findViewById(R.id.textView4);
            textView3 = tv.findViewById(R.id.textView5);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public DiseasAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setmDataSet(ArrayList<Produccion> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public DiseasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // Creamos una nueva vista
        View tv = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease_view, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings, etc
        return  new ViewHolder(tv);
    }

    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos

        holder.textView1.setText(mDataSet.get(position).getProducto());
        holder.textView2.setText(mDataSet.get(position).getEstadoCompra());
        holder.textView3.setText(mDataSet.get(position).getSupermercado());


    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}