package com.example.deliveryya;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MenuOpciones extends AppCompatActivity{

    ImageView helados;
    private ImageView carroCompras;
    private EditText textoBuscador;

    ImageView usuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);


    usuario = findViewById(R.id.iconoUser);

    usuario.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuOpciones.this, UserDashboard.class);
            startActivity(intent);
            finish(); // Finalizamos la actividad actual.
        }
    });


        // Enlazamos la variable 'helados' con el botón de helados en la interfaz.
        helados = findViewById(R.id.btn_helados);

        // Configuramos un listener para el botón de helados.
        helados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón de helados, se inicia una nueva actividad (ProductosPostres).
                Intent intent = new Intent(MenuOpciones.this, ProductosPostres.class);
                startActivity(intent);
                finish(); // Finalizamos la actividad actual.
            }
        });

        // Enlazamos la variable 'carroCompras' con la imagen del carro de compras en la interfaz.
        carroCompras = findViewById(R.id.img_cart);

        // Configuramos un listener para la imagen del carro de compras.
        carroCompras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Mostramos un mensaje de Toast indicando que el carro de compras está vacío.
                Toast.makeText(getApplicationContext(), "Carro de compras vacío", Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos la variable 'textoBuscador' con el campo de texto de búsqueda en la interfaz.
        textoBuscador = findViewById(R.id.etBuscador);

        // Configuramos un listener para el campo de texto de búsqueda que cambia el texto de hint según el enfoque.
        textoBuscador.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    textoBuscador.setHint(""); // Cuando se enfoca, el hint se elimina.
                } else {
                    textoBuscador.setHint("¿Qué estás buscando?"); // Cuando se pierde el enfoque, se restablece el hint.
                }
            }
        });
    }

    // Método que maneja la pulsación del botón de retroceso.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
            // Si se pulsa el botón de retroceso, mostramos un cuadro de diálogo de confirmación.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Si se confirma la salida, se inicia la pantalla de inicio del sistema.
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Si se cancela, se cierra el cuadro de diálogo.
                }
            });
            builder.show(); // Mostramos el cuadro de diálogo.
        }
        return super.onKeyDown(keyCode, event);
    }
}
