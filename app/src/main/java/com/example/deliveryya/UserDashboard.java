package com.example.deliveryya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.widget.Button;
public class UserDashboard extends AppCompatActivity {

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
    }
}