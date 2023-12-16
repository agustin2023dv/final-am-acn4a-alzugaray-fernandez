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

    ImageView perfilUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);

        // Obtener una referencia al botón de retroceso y agregar un OnClickListener para simular el comportamiento de retroceso
        ImageView iconoAtras = findViewById(R.id.iconoAtras);
        iconoAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Llama al método onBackPressed para simular el comportamiento de retroceso
            }
        });

        // Obtener una referencia a la imagen del perfil de usuario y agregar un OnClickListener para redirigir a la actividad UserDashboard
        perfilUsuario = findViewById(R.id.iconoUser);
        perfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosPostres.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        });

        // Obtener una referencia a la imagen del carrito de compras y agregar un OnClickListener para abrir la actividad CarritoCompras
        ImageView imgCart = findViewById(R.id.img_cart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para abrir la actividad "activity_carrito_compras.xml"
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);
                startActivity(intent);
            }
        });

        // Obtener una referencia a los botones de compra para los productos
        Button btnComprarHeladoVainilla = findViewById(R.id.btnComprarHeladoVainilla);
        Button btnComprarHeladoChocolate = findViewById(R.id.btnComprarHeladoChocolate);
        Button btnComprarHeladoFrutilla = findViewById(R.id.btnComprarHeladoFrutilla);
        Button btnComprarHeladoLimon = findViewById(R.id.btnComprarHeladoLimon);

        // Agregar un OnClickListener al botón de compra de Helado de Vainilla
        btnComprarHeladoVainilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductosPostres.this,
                        "Has agregado Helado de Vainilla al carrito de compra", Toast.LENGTH_SHORT).show();
                // Obtener referencias a los elementos de información del producto
                TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoVainilla);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoVainilla);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoVainilla);

                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                intent.putExtra("cantidadHVainilla", 1);

                // Iniciar la actividad CarritoCompras
                startActivity(intent);
            }
        });

        // Agregar un OnClickListener al botón de compra de Helado de Chocolate
        btnComprarHeladoChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductosPostres.this,
                        "Has agregado Helado de Chocolate al carrito de compra", Toast.LENGTH_SHORT).show();
                // Obtener referencias a los elementos de información del producto
                TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoChocolate);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoChocolate);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoChocolate);

                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                intent.putExtra("cantidadHVainilla", 1);

                // Iniciar la actividad CarritoCompras
                startActivity(intent);

            }
        });
        // Agregar un OnClickListener al botón de compra de Helado de Frutilla
        btnComprarHeladoFrutilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductosPostres.this,
                        "Has agregado Helado de Frutilla al carrito de compra", Toast.LENGTH_SHORT).show();
                // Obtener referencias a los elementos de información del producto
                TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoFrutilla);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoFrutilla);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoFrutilla);

                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                intent.putExtra("cantidadHVainilla", 1);

                // Iniciar la actividad CarritoCompras
                startActivity(intent);
            }
        });
        // Agregar un OnClickListener al botón de compra de Helado de Limon
        btnComprarHeladoLimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductosPostres.this,
                        "Has agregado Helado de Limon al carrito de compra", Toast.LENGTH_SHORT).show();
                // Obtener referencias a los elementos de información del producto
                TextView txtNombreProducto = findViewById(R.id.txtNombreHeladoLimon);
                TextView txtDescProducto = findViewById(R.id.txtDescripcionHeladoLimon);
                TextView txtPrecioProducto = findViewById(R.id.txtPrecioHeladoLimon);

                // Crear un Intent para abrir la actividad CarritoCompras
                Intent intent = new Intent(ProductosPostres.this, CarritoCompras.class);

                // Agregar los datos del helado como extras en el Intent
                intent.putExtra("nombreProducto", txtNombreProducto.getText().toString());
                intent.putExtra("descripcionProducto", txtDescProducto.getText().toString());
                intent.putExtra("precioProducto", Double.parseDouble(txtPrecioProducto.getText().toString()));
                intent.putExtra("cantidadHVainilla", 1);

                // Iniciar la actividad CarritoCompras
                startActivity(intent);
            }
        });

    }
}
