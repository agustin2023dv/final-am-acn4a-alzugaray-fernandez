package com.example.deliveryya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryya.models.Producto;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ProductosPostres extends AppCompatActivity {



    private List<Producto> carritoCompras = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);


        ImageView imgCart = findViewById(R.id.img_cart);


        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para abrir la actividad "activity_carrito_compras.xml"
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);
                startActivity(intent);
            }
        });





        Button btnComprarHeladoVainilla = findViewById(R.id.btnComprarHeladoVainilla);
        btnComprarHeladoVainilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

   /*           Toast.makeText(ProductosPostres.this,
                      "Has agregado Helado de Vainilla al carrito de compra", Toast.LENGTH_SHORT).show(); */


               TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoVainilla);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoVainilla);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoVainilla);



                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                // Iniciar la actividad CarritoCompras
                startActivity(intent);
            }
        });








        Button btnComprarHeladoChocolate = findViewById(R.id.btnComprarHeladoChocolate);
        btnComprarHeladoChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ProductosPostres.this, "Has agregado Helado de Chocolate al carrito de compra", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
