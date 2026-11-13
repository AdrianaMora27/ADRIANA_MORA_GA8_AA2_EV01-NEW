package com.lucimakeup.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        EditText etNombre = findViewById(R.id.etNombreEnvio);
        EditText etDireccion = findViewById(R.id.etDireccionEnvio);
        EditText etTel = findViewById(R.id.etTelefonoEnvio);
        Button btnConfirmar = findViewById(R.id.btnConfirmarPedido);

        btnConfirmar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String dir = etDireccion.getText().toString().trim();
            String tel = etTel.getText().toString().trim();

            if (nombre.isEmpty() || dir.isEmpty() || tel.isEmpty()) {
                Toast.makeText(this, "Por favor complete los datos de envío", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "¡Pedido confirmado con éxito! Gracias por comprar en Lucimakeup", Toast.LENGTH_LONG).show();
            
            // Reiniciar carrito y volver al catálogo principal
            CatalogActivity.totalProductosCarrito = 0;
            CatalogActivity.subtotalCarrito = 0;
            
            Intent intent = new Intent(CheckoutActivity.this, CatalogActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
