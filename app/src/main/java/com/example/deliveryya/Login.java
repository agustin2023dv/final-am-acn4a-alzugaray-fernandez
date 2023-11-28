package com.example.deliveryya;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
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


    private EditText emailEditText;
    private EditText passwordEditText;
    private LinearLayout linearLayout;
    private ScrollView scrollView;


    private int elementCount = 0;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    /*    if(currentUser != null){

            Intent intent = new Intent(getApplicationContext(), ProductosPostres.class);
            startActivity(intent);
            finish();
        }*/
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mAuth= FirebaseAuth.getInstance();



        progressBarLogin = findViewById(R.id.progressBarLogin);

        btnLogin = findViewById(R.id.btnLogin);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);

        registrateAhora= findViewById(R.id.txtRegistrateAhora);

        registrateAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), Registro.class);
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

                if(TextUtils.isEmpty(email)){

                    Toast.makeText(Login.this, "Ingrese un correo electronico",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    Toast.makeText(Login.this, "Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBarLogin.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(),"Login exitoso",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),MenuOpciones.class);
                                    startActivity(intent);
                                    finish();

                                } else {

                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
/*
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Botón de inicio de sesión presionado", Toast.LENGTH_SHORT).show();

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
        elementCount++;*/
    }}