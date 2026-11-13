package com.lucimakeup.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private boolean esModoRegistro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvTitulo = findViewById(R.id.tvTituloAuth);
        TextView tvSubtitulo = findViewById(R.id.tvSubtituloAuth);
        EditText etNombre = findViewById(R.id.etNombreRegistro);
        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etContrasena = findViewById(R.id.etContrasena);
        Button btnAccion = findViewById(R.id.btnAccionAuth);
        TextView tvCambiarModo = findViewById(R.id.tvCambiarModoAuth);

        tvCambiarModo.setOnClickListener(v -> {
            esModoRegistro = !esModoRegistro;
            if (esModoRegistro) {
                tvTitulo.setText("Crear Cuenta");
                tvSubtitulo.setText("Regístrate para comprar en Lucimakeup");
                etNombre.setVisibility(View.VISIBLE);
                btnAccion.setText("REGISTRARME");
                tvCambiarModo.setText("¿Ya tienes cuenta? Inicia sesión");
            } else {
                tvTitulo.setText("Iniciar Sesión");
                tvSubtitulo.setText("Ingresa tus datos para explorar Lucimakeup");
                etNombre.setVisibility(View.GONE);
                btnAccion.setText("INGRESAR");
                tvCambiarModo.setText("¿No tienes cuenta? Regístrate aquí");
            }
        });

        btnAccion.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            String clave = etContrasena.getText().toString().trim();

            if (correo.isEmpty() || clave.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Por favor completa correo y contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            String mensaje = esModoRegistro ? "¡Registro exitoso! Bienvenida a Lucimakeup" : "¡Bienvenida de nuevo!";
            Toast.makeText(LoginActivity.this, mensaje, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, CatalogActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
