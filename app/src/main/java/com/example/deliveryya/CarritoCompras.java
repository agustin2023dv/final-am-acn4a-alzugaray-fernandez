package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deliveryya.models.Producto;

import java.util.List;

public class CarritoCompras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);

        // Obtener los datos del helado del Intent
        String nombreProducto = getIntent().getStringExtra("nombreProducto");
        String descripcionProducto = getIntent().getStringExtra("descripcionProducto");
        double precioProducto = getIntent().getDoubleExtra("precioProducto", 0.0);

        TextView txtNombreProducto = findViewById(R.id.txtNombreProducto);
        TextView txtDescProducto = findViewById(R.id.txtDescripcionProducto);
        TextView txtPrecioProducto = findViewById(R.id.txtPrecioProducto);

        // Establecer los datos del helado en las vistas
        txtNombreProducto.setText(nombreProducto);
        txtDescProducto.setText(descripcionProducto);
        txtPrecioProducto.setText(String.valueOf(precioProducto));

    }
}
