package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class CarritoCompras extends AppCompatActivity {

    private int cantidadHVainilla = 0; //
    private double precioTotal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);



        ImageView iconoAtras = findViewById(R.id.iconoAtras);

        iconoAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Llama al método onBackPressed para simular el comportamiento de retroceso
            }
        });







        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnMas = findViewById(R.id.btnMas);

        // Obtener los datos del helado del Intent
        String nombreProducto = getIntent().getStringExtra("nombreProducto");
        String descripcionProducto = getIntent().getStringExtra("descripcionProducto");
        double precioProducto = getIntent().getDoubleExtra("precioProducto", 0.0);

        TextView txtNombreProducto = findViewById(R.id.txtNombreProducto);
        TextView txtDescProducto = findViewById(R.id.txtDescripcionProducto);
        TextView txtPrecioHVainilla = findViewById(R.id.txtPrecioProducto);


        TextView txtPrecioTotal = findViewById(R.id.txtValorTotal);

        TextView txtCantidadHVainilla = findViewById(R.id.txtCantidadHVainilla);
        txtCantidadHVainilla.setText("1");

        // Establecer los datos del helado en las vistas
        txtNombreProducto.setText(nombreProducto);
        txtDescProducto.setText(descripcionProducto);
        txtPrecioHVainilla.setText(String.valueOf(precioProducto));

        precioTotal += precioProducto;
        txtPrecioTotal.setText(String.valueOf(precioTotal));



        // Manejar clic en el botón "-"
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reducir la cantidad en 1 si es mayor que 0
                if (cantidadHVainilla > 0) {
                    cantidadHVainilla--;
                    txtCantidadHVainilla.setText(String.valueOf(cantidadHVainilla));
                    precioTotal -= precioProducto;
                    txtPrecioTotal.setText(String.valueOf(precioTotal));;
                }
                else {
                    cantidadHVainilla = 0;
                    precioTotal -= precioProducto;
                    txtPrecioTotal.setText(String.valueOf(precioTotal));
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
                precioTotal += precioProducto;
                txtPrecioTotal.setText(String.valueOf(precioTotal));
            }
        });



    }


    }




