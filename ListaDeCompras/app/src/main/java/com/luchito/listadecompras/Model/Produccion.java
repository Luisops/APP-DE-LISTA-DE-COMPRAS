package com.luchito.listadecompras.Model;

public class Produccion {


    String Producto;
    String Supermercado;
    String EstadoCompra;


    public Produccion(){

    }
    public Produccion(String Producto, String Supermercado, String EstadoCompra){
        this.Producto=Producto;
        this.Supermercado=Supermercado;
        this.EstadoCompra=EstadoCompra;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getSupermercado() {
        return Supermercado;
    }

    public void setSupermercado(String supermercado) {
        Supermercado = supermercado;
    }


    public String getEstadoCompra() {
        return EstadoCompra;
    }

    public void setEstadoCompra(String estadoCompra) {
        EstadoCompra = estadoCompra;
    }
}
