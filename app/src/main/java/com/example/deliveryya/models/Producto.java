package com.example.deliveryya.models;

public class Producto {

    private String nombre;
    private String descripcion;
    private int id;
    private double precio;

    // Constructor
    public Producto(String nombre, String descripcion, int id, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.precio = precio;
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
