package com.example.deliveryya;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.deliveryya.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosPostres extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);


        listaProductos = new ArrayList<>();


        listaProductos.add(new Producto("Producto 1", "Descripción 1", 1, 10.99));
        listaProductos.add(new Producto("Producto 2", "Descripción 2", 2, 19.99));
        listaProductos.add(new Producto("Producto 3", "Descripción 3", 3, 5.99));


    }
}
