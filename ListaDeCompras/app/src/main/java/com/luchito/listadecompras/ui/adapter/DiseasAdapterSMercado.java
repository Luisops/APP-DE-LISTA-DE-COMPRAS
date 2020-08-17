package com.luchito.listadecompras.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.luchito.listadecompras.Model.SuperMercado;
import com.luchito.listadecompras.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DiseasAdapterSMercado extends RecyclerView.Adapter<DiseasAdapterSMercado.ViewHolder> {
    private ArrayList<SuperMercado> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public ImageView imageViewFull;
        public TextView textViewNombre;
        public TextView textViewTelefono;
        public TextView textViewDireccion;
        public TextView textViewDistrito;

        public ViewHolder(View tvi) {
            super(tvi);
            imageViewFull =tvi.findViewById(R.id.imageViewFull);
            textViewNombre = tvi.findViewById(R.id.textViewNombre);
            textViewTelefono = tvi.findViewById(R.id.textViewTelefono);
            textViewDireccion = tvi.findViewById(R.id.textViewDireccion);
            textViewDistrito = tvi.findViewById(R.id.textViewDistrito);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public DiseasAdapterSMercado() {

        mDataSet = new ArrayList<>();
    }
    public void setmDataSet(ArrayList<SuperMercado> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }
    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public DiseasAdapterSMercado.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // Creamos una nueva vista
        View tvi = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease_view_smercado, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings, etc
        return  new ViewHolder(tvi);
    }

    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos
       // holder.imageViewFull.setTe
        Picasso.get().load("https://image.freepik.com/vector-gratis/tienda-dibujos-animados-compras_18591-42797.jpg").into(holder.imageViewFull);
        holder.textViewNombre.setText(mDataSet.get(position).getNombre());
        holder.textViewTelefono.setText(mDataSet.get(position).getTelefono());
        holder.textViewDireccion.setText(mDataSet.get(position).getDireccion());
        holder.textViewDistrito.setText(mDataSet.get(position).getDistrito());
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
