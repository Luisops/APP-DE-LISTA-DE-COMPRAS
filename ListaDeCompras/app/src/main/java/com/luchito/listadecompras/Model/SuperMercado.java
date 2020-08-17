package com.luchito.listadecompras.Model;

public class SuperMercado {

    int TO_BASE64;
    String Nombre,Direccion,Distrito,Telefono;

    public SuperMercado(int TO_BASE64, String nombre, String direccion, String distrito, String telefono) {
        this.TO_BASE64 = TO_BASE64;
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Distrito = distrito;
        this.Telefono = telefono;
    }

    public int getTO_BASE64() {
        return TO_BASE64;
    }

    public void setTO_BASE64(int TO_BASE64) {
        this.TO_BASE64 = TO_BASE64;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
