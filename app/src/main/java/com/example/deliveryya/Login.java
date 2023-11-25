package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private int elementCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout); // Agregar esta línea para encontrar el LinearLayout

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Botón de inicio de sesión presionado", Toast.LENGTH_SHORT).show();
                // Agrega lógica de inicio de sesión aquí
            }
        });
    }

    public void forgotPasswordClick(View view) {
        // Lógica cuando se hace clic en "Olvidé mi contraseña"
    }

    public void createAccountClick(View view) {
        // Lógica cuando se hace clic en "Crear una cuenta nueva"

        // Agregar un nuevo elemento de texto al ScrollView dinámicamente
        TextView textView = new TextView(this);
        textView.setText("Cuenta " + (elementCount + 1) + " creada");
        linearLayout.addView(textView);
        elementCount++;
    }}