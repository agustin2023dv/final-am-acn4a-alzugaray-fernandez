package com.example.deliveryya.models;

public class CProducto {
    private String nombre;
    private int id;
    private String imagen;
    private double precio;

    // Constructor

    public CProducto(){};
    public CProducto(String nombre, int id, String imagen, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.imagen = imagen;
        this.precio = precio;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
