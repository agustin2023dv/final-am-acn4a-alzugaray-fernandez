package com.example.deliveryya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MapaRestaurantes extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud,txtLongitud;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_restaurantes);

        FirebaseApp.initializeApp(this);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("restaurante")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String nombreRestaurante = document.getString("nombre_restaurante");
                            double latitud = Double.parseDouble(document.getString("latitud"));
                            double longitud = Double.parseDouble(document.getString("longitud"));

                            // Agregar un marcador para cada restaurante en el mapa
                            LatLng restauranteLatLng = new LatLng(latitud, longitud);
                            mMap.addMarker(new MarkerOptions().position(restauranteLatLng).title(nombreRestaurante));
                        }
                    } else {
                        // Manejar errores aquí
                    }
                });

        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng caba = new LatLng(-34.6323498,-58.4853198);
        mMap.addMarker(new MarkerOptions().position(caba).title("Ciudad Autonoma de Buenos Aires"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng caba = new LatLng(-34.6323498,-58.4853198);
        mMap.addMarker(new MarkerOptions().position(caba).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        LatLng caba = new LatLng(-34.6323498,-58.4853198);
        mMap.addMarker(new MarkerOptions().position(caba).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));
    }
}