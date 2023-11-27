package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import android.util.Log;
import android.content.ContentValues;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.firebase.auth.FirebaseUser;

import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    TextInputEditText emailText, passwordText;
TextView loginAhora;
    ProgressBar progressBarRegistro;
    FirebaseAuth mAuth;
    Button btnRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        mAuth= FirebaseAuth.getInstance();

        loginAhora = findViewById(R.id.txtLoginAhora);

        progressBarRegistro = findViewById(R.id.progressBarRegistro);

        btnRegistro = findViewById(R.id.btnRegistro);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);


        loginAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBarRegistro.setVisibility(View.VISIBLE);

                String email, password;
                email = emailText.getText().toString();
                password = passwordText.getText().toString();

                if(TextUtils.isEmpty(email)){

                    Toast.makeText(Registro.this, "Ingrese un correo electronico",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    Toast.makeText(Registro.this, "Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBarRegistro.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(Registro.this, "Se ha registrado correctamente",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent =  new Intent(Registro.this, Login.class);
                                    startActivity(intent);
                                    finish();
                                } else {

                                    Toast.makeText(Registro.this, "Creacion de usuario no exitosa.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
      /*  if(currentUser != null){

            Intent intent = new Intent(getApplicationContext(), ProductosPostres.class);
            startActivity(intent);
            finish();
        }*/
    }
}