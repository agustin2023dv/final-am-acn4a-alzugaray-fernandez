package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import com.example.deliveryya.models.Producto;

import java.util.List;

public class CarritoCompras extends AppCompatActivity {

    private int cantidadHVainilla = 0; //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);


        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnMas = findViewById(R.id.btnMas);

        // Obtener los datos del helado del Intent
        String nombreProducto = getIntent().getStringExtra("nombreProducto");
        String descripcionProducto = getIntent().getStringExtra("descripcionProducto");
        double precioProducto = getIntent().getDoubleExtra("precioProducto", 0.0);

        TextView txtNombreProducto = findViewById(R.id.txtNombreProducto);
        TextView txtDescProducto = findViewById(R.id.txtDescripcionProducto);
        TextView txtPrecioProducto = findViewById(R.id.txtPrecioProducto);

        TextView txtCantidadHVainilla = findViewById(R.id.txtCantidadHVainilla);


        // Establecer los datos del helado en las vistas
        txtNombreProducto.setText(nombreProducto);
        txtDescProducto.setText(descripcionProducto);
        txtPrecioProducto.setText(String.valueOf(precioProducto));




        // Manejar clic en el botón "-"
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reducir la cantidad en 1 si es mayor que 0
                if (cantidadHVainilla > 0) {
                    cantidadHVainilla--;
                    txtCantidadHVainilla.setText(String.valueOf(cantidadHVainilla));
                }
                else {
                    cantidadHVainilla = 0;
                }
            }
        });

        // Manejar clic en el botón "+"
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aumentar la cantidad en 1
                cantidadHVainilla ++;
                txtCantidadHVainilla.setText(String.valueOf(cantidadHVainilla));
            }
        });



    }


    }




