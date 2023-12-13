package com.example.deliveryya.models;

import java.util.ArrayList;
import java.util.List;

public class CRestaurante {
    private String nombre;
    private int id;
    private String direccion;
    private String imagen;
    private List<CProducto> listaProductos;

    // Constructor
    public CRestaurante(){};
    public CRestaurante(String nombre, int id,
                        String direccion, String imagen) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.imagen = imagen;
        this.listaProductos = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<CProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<CProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // Método para agregar un producto a la lista de productos del restaurante
    public void agregarProducto(CProducto producto) {
        this.listaProductos.add(producto);
    }

    // Método para eliminar un producto de la lista de productos del restaurante
    public void eliminarProducto(CProducto producto) {
        this.listaProductos.remove(producto);
    }
}
