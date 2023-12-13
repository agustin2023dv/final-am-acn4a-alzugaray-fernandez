package com.example.deliveryya;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductosPostres extends AppCompatActivity {


    ImageView perfilUsuario ;


    private String urlMenuHamburguesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);


        perfilUsuario = findViewById(R.id.iconoUser);

        ImageView imgBurgerMenu = findViewById(R.id.img_burgermenu);

        urlMenuHamburguesa = getString(R.string.urlMenuHamburguesa);
        // Cargar la imagen desde la URL
        Picasso.get().load(urlMenuHamburguesa).into(imgBurgerMenu, new Callback() {
            @Override
            public void onSuccess() {
                // Imagen cargada con éxito
                imgBurgerMenu.setColorFilter(ContextCompat.getColor(ProductosPostres.this, R.color.color_principal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onError(Exception e) {
                // Manejar errores
                e.printStackTrace();
            }
        });

        perfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosPostres.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        });



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








               TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoVainilla);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoVainilla);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoVainilla);



                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                intent.putExtra("cantidadHVainilla",1);
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
