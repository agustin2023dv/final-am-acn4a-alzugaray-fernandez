package com.example.deliveryya;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.SearchView;
import android.widget.TableLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MenuOpciones extends AppCompatActivity{

    ImageView helados;
    private ImageView carroCompras;
    private EditText textoBuscador;
    private String urlMenuHamburguesa;
    ImageView perfilUsuario ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

        perfilUsuario = findViewById(R.id.iconoUser);



        perfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuOpciones.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView imgBurgerMenu = findViewById(R.id.img_burgermenu);

        urlMenuHamburguesa = getString(R.string.urlMenuHamburguesa);
        // Cargar la imagen desde la URL
        Picasso.get().load(urlMenuHamburguesa).into(imgBurgerMenu, new Callback() {
            @Override
            public void onSuccess() {
                // Imagen cargada con éxito
                imgBurgerMenu.setColorFilter(ContextCompat.getColor(MenuOpciones.this, R.color.black), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onError(Exception e) {
                // Manejar errores
                e.printStackTrace();
            }
        });
        imgBurgerMenu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Función en desarrollo", Toast.LENGTH_SHORT).show();

            }
        });

        textoBuscador = findViewById(R.id.etBuscador);


        helados = findViewById(R.id.btn_helados);

        helados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuOpciones.this,ProductosPostres.class);
                startActivity(intent);
                finish();
            }
        });


        carroCompras = findViewById(R.id.img_cart);
        carroCompras.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Carro de compras vacio", Toast.LENGTH_SHORT).show();

            }
        });

        textoBuscador = findViewById(R.id.etBuscador);

        textoBuscador.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    textoBuscador.setHint("");
                } else {
                    textoBuscador.setHint("¿Qué estás buscando?");
                }
            }
        });
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
