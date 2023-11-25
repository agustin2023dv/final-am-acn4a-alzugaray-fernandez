package com.example.deliveryya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.deliveryya.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosPostres extends AppCompatActivity {

    List<Producto> carritoCompras = new ArrayList<Producto>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);


        ImageView imgCart = findViewById(R.id.img_cart);

        // Configurar un clic en el ImageView
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

                Toast.makeText(ProductosPostres.this, "Has agregado Helado de Vainilla al carrito de compra", Toast.LENGTH_SHORT).show();

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
