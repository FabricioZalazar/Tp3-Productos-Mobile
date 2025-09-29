package com.example.tp3_productos.model;

import androidx.annotation.Nullable;

import java.util.Objects;

public class Producto {

    private int codigo;
    private String descripcion;
    private double precio;

    public Producto(double precio, String descripcion, int codigo) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
