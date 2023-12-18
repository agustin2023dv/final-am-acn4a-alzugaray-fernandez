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
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;

import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class UserDashboard extends AppCompatActivity {

    // Inicializa una instancia de Firestore.
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Obtiene el ID del usuario actualmente autenticado.
    String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

    ImageView imagenPerfil;

    // Inicializa el ActivityResultLauncher para elegir una imagen de la galería.
    private final ActivityResultLauncher<String> pickMedia = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    imagenPerfil.setImageURI(uri); // Establece la imagen seleccionada como imagen de perfil.
                } else {
                    Toast.makeText(UserDashboard.this,"Por favor selecciona una imagen.",Toast.LENGTH_SHORT).show();
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

        ImageView iconoAtras = findViewById(R.id.iconoAtras);

        iconoAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, MenuOpciones.class);
                startActivity(intent);
                // Finaliza la actividad actual
                finish();
            }
        });

        // Realiza una consulta en Firestore para obtener los detalles del usuario actual.
        db.collection("usuario")
                .whereEqualTo("uid", userID)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        // Se encontró  un documento con el ID de usuario actual.


                        // Obtiene el nombre y el apellido del usuario desde Firestore.
                        String nombre = queryDocumentSnapshots.getDocuments().get(0).getString("nombre");
                        String apellido = queryDocumentSnapshots.getDocuments().get(0).getString("apellido");

                        // Mostrar el nombre y el apellido en los TextView correspondientes.
                        TextView txtNombreStorage = findViewById(R.id.txtNombreStorage);
                        TextView txtApellidoStorage = findViewById(R.id.txtApellidoStorage);
                        txtNombreStorage.setText(nombre);
                        txtApellidoStorage.setText(apellido);
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(UserDashboard.this,"Error al cargar datos del usuario",
                            Toast.LENGTH_SHORT).show();
                });

        // Inicializa FirebaseAuth y obtiene el usuario actualmente autenticado.
        auth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        txtDetallesUsuario = findViewById(R.id.txtDetallesUsuario);
        imagenPerfil = findViewById(R.id.imageViewProfile);

        // Obtiene el usuario actualmente autenticado.
        usuario = auth.getCurrentUser();

        if (usuario == null) {
            // Si no hay usuario autenticado, redirige a la actividad de inicio de sesión.
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            txtDetallesUsuario.setText(usuario.getEmail()); // Muestra el correo electrónico del usuario autenticado.
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la sesión del usuario y redirige a la actividad de inicio de sesión.
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        // Carga una imagen de perfil predeterminada usando Picasso en la ImageView.
        Picasso.get()
                .load(
                        "https://thumbs.dreamstime.com/b/hombre-gris-del-placeholder-de-la-foto-persona-gen%C3%A9rica-silueta-en-un-fondo-blanco-144511705.jpg")
                .error(R.mipmap.ic_launcher_round) // Imagen de error en caso de fallo.
                .into(imagenPerfil);

        Button btnCambiarFotoPerfil = findViewById(R.id.btnCargarImagen);

        btnCambiarFotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre el selector de medios para elegir una imagen.
                pickMedia.launch("image/*");
            }
        });
    }
}