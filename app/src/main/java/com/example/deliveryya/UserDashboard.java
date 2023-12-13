package com.example.deliveryya;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.activity.result.ActivityResultLauncher;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

public class UserDashboard extends AppCompatActivity {
    // Creación de una instancia de FirebaseStorage para trabajar con almacenamiento en la nube
    FirebaseStorage storage = FirebaseStorage.getInstance();
    ImageView imagenPerfil;

    // Declaración de un ActivityResultLauncher para seleccionar imágenes de la galería
    private final ActivityResultLauncher<String> pickMedia = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    // Establece la imagen de perfil con la URI seleccionada
                    imagenPerfil.setImageURI(uri);
                } else {
                    // Manejar caso en el que no se selecciona ninguna imagen
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

        // Inicializa Firebase Authentication
        auth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        txtDetallesUsuario = findViewById(R.id.txtDetallesUsuario);
        imagenPerfil = findViewById(R.id.imageViewProfile);

        // Obtiene el usuario autenticado actualmente
        usuario = auth.getCurrentUser();

        if (usuario == null) {
            // Si el usuario no está autenticado, redirige a la pantalla de inicio de sesión
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            // Muestra el correo electrónico del usuario autenticado
            txtDetallesUsuario.setText(usuario.getEmail());
        }

        btnLogout.setOnClickListener(v -> {
            // Cierra la sesión de Firebase Authentication y redirige a la pantalla de inicio de sesión
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });

        // Carga una imagen de perfil predeterminada usando la biblioteca Picasso
        Picasso.get()
                .load("https://thumbs.dreamstime.com/b/hombre-gris-del-placeholder-de-la-foto-persona-gen%C3%A9rica-silueta-en-un-fondo-blanco-144511705.jpg")
                .error(R.mipmap.ic_launcher_round)
                .into(imagenPerfil);

        // Encuentra el botón para cambiar la foto de perfil
        Button btnCambiarFotoPerfil = findViewById(R.id.btnCargarImagen);

        btnCambiarFotoPerfil.setOnClickListener(view -> {
            // Abre el selector de medios para elegir una imagen
            pickMedia.launch("image/*");
        });
    }
}
