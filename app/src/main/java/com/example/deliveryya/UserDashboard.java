package com.example.deliveryya;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import com.squareup.picasso.Picasso;

public class UserDashboard extends AppCompatActivity {

    ImageView imagenPerfil;
    private final ActivityResultLauncher<String> pickMedia = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    imagenPerfil.setImageURI(uri);
                } else {

                }
            }
    );


    FirebaseAuth auth;


    FirebaseUser usuario;
    Button btnLogout;
    TextView txtDetallesUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        auth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        txtDetallesUsuario = findViewById(R.id.txtDetallesUsuario);

        usuario = auth.getCurrentUser();

        if(usuario == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else{
            txtDetallesUsuario.setText(usuario.getEmail());
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


        imagenPerfil = findViewById(R.id.imageViewProfile);
        Picasso.get().
                load("https://thumbs.dreamstime.com/b/hombre-gris-del-placeholder-de-la-foto-persona-gen%C3%A9rica-silueta-en-un-fondo-blanco-144511705.jpg").
                error(R.mipmap.ic_launcher_round).into(imagenPerfil);

        Button btnCambiarFotoPerfil= findViewById(R.id.btnCargarImagen);


        btnCambiarFotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre el selector de medios para elegir una imagen
                pickMedia.launch("image/*");
            }
        });








    }
}