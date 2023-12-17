package com.example.deliveryya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MapaRestaurantes extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtNombreRestaurante, txtInfoRestaurante;
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
                            // Obtener datos del restaurante desde Firestore
                            String nombreRestaurante = document.getString("nombre_restaurante");
                            double latitud = Double.parseDouble(document.getString("latitud"));
                            double longitud = Double.parseDouble(document.getString("longitud"));
                            String telefono = document.getString("telefono");
                            String domicilio = document.getString("direccion");

                            // Verificar si no hay información de teléfono
                            if (telefono == null) {
                                telefono = "No hay información";
                            }

                            // Combina todos los datos en una sola cadena, separados por saltos de línea
                            String snippet = "Domicilio: " + domicilio + "\n" +
                                    "Teléfono: " + telefono + "\n";

                            // Agregar un marcador para cada restaurante en el mapa
                            LatLng restauranteLatLng = new LatLng(latitud, longitud);
                            mMap.addMarker(new MarkerOptions().position(restauranteLatLng).title(nombreRestaurante).
                                    snippet(snippet));
                        }
                    } else {
                        Toast.makeText(MapaRestaurantes.this, "Error en base de datos.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        txtNombreRestaurante = findViewById(R.id.txtNombreRestaurante);
        txtInfoRestaurante = findViewById(R.id.txtInfoRestaurante);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        // Establecer la posición de la cámara inicial
        LatLng caba = new LatLng(-34.6323498, -58.4853198);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));

        // Configurar el clic en un marcador
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // Obtener el título del marcador (nombre del restaurante)
                String restauranteNombre = marker.getTitle();

                // Obtener la información del restaurante desde el snippet
                String infoRestaurante = marker.getSnippet();

                // Mostrar la información en los EditText
                txtNombreRestaurante.setText(restauranteNombre);
                txtInfoRestaurante.setText(infoRestaurante);

                // Devolver 'true' para indicar que el evento ha sucedido
                return true;
            }
        });
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        // Limpiar todos los marcadores al hacer clic en el mapa
        mMap.clear();

        // Establecer la posición de la cámara nuevamente
        LatLng caba = new LatLng(-34.6323498, -58.4853198);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        // Establecer la posición de la cámara al hacer una pulsación larga en el mapa
        LatLng caba = new LatLng(-34.6323498, -58.4853198);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caba));
    }
}
