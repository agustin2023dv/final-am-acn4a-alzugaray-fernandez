package com.example.deliveryya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.deliveryya.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosPostres extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_postres);


        Button btnComprarHeladoVainilla = findViewById(R.id.btnComprarHeladoVainilla);
        btnComprarHeladoVainilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Maneja el evento de clic del botón aquí
                Toast.makeText(ProductosPostres.this, "Has comprado Helado de Vainilla", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
