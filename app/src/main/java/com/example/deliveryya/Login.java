package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextInputEditText emailText, passwordText;
    TextView registrateAhora;
    ProgressBar progressBarLogin;
    FirebaseAuth mAuth;
    Button btnLogin;

    @Override
    public void onStart() {
        super.onStart();
        // Comprobar si el usuario está autenticado (no nulo) y actualizar la interfaz de usuario en consecuencia.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        progressBarLogin = findViewById(R.id.progressBarLogin);
        btnLogin = findViewById(R.id.btnLogin);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        registrateAhora = findViewById(R.id.txtRegistrateAhora);

        registrateAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad de registro al hacer clic en el enlace "Regístrate ahora".
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarLogin.setVisibility(View.VISIBLE);

                String email, password;
                email = emailText.getText().toString();
                password = passwordText.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBarLogin.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        if (user.isEmailVerified()) {
                                            // Si el inicio de sesión es exitoso y el correo electrónico está verificado, redirigir al menú de opciones.
                                            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), MenuOpciones.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            // Si el correo electrónico no está verificado, mostrar un mensaje.
                                            Toast.makeText(Login.this, "Verifique su correo electrónico antes de iniciar sesión", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    // Manejar la autenticación fallida.
                                    Toast.makeText(Login.this, "Falló la autenticación.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
