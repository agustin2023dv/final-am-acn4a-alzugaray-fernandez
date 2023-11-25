package com.example.deliveryya;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        View layoutProductoView = findViewById(R.id.layoutProducto);


    }
}
