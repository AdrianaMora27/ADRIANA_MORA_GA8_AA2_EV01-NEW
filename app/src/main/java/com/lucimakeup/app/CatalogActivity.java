package com.lucimakeup.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogActivity extends Activity {

    public static int totalProductosCarrito = 0;
    public static int subtotalCarrito = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        LinearLayout panelLateral = findViewById(R.id.panelLateralCategorias);
        Button btnMenu = findViewById(R.id.btnMenuCategorias);
        Button btnCerrarPanel = findViewById(R.id.btnCerrarPanel);
        Button btnVerCarrito = findViewById(R.id.btnVerCarrito);
        Button btnVerDetalle1 = findViewById(R.id.btnVerDetalle1);
        TextView tvCategoriaActual = findViewById(R.id.tvCategoriaActual);
        TextView tvContador = findViewById(R.id.tvContadorCarrito);

        tvContador.setText(String.valueOf(totalProductosCarrito));

        // Panel lateral
        btnMenu.setOnClickListener(v -> panelLateral.setVisibility(View.VISIBLE));
        btnCerrarPanel.setOnClickListener(v -> panelLateral.setVisibility(View.GONE));

        // Filtros de categorías
        findViewById(R.id.btnCatTodas).setOnClickListener(v -> {
            tvCategoriaActual.setText("Categoría: Todos los Productos");
            panelLateral.setVisibility(View.GONE);
        });
        findViewById(R.id.btnCatRostro).setOnClickListener(v -> {
            tvCategoriaActual.setText("Categoría: Rostro");
            panelLateral.setVisibility(View.GONE);
        });
        findViewById(R.id.btnCatOjos).setOnClickListener(v -> {
            tvCategoriaActual.setText("Categoría: Ojos");
            panelLateral.setVisibility(View.GONE);
        });
        findViewById(R.id.btnCatLabios).setOnClickListener(v -> {
            tvCategoriaActual.setText("Categoría: Labios");
            panelLateral.setVisibility(View.GONE);
        });

        // Ver Detalle del Producto 1
        btnVerDetalle1.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogActivity.this, ProductDetailActivity.class);
            startActivity(intent);
        });

        // Ir al Carrito
        btnVerCarrito.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Cerrar Sesión
        findViewById(R.id.btnCerrarSesion).setOnClickListener(v -> {
            Toast.makeText(this, "Sesión cerrada correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CatalogActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tvContador = findViewById(R.id.tvContadorCarrito);
        if (tvContador != null) {
            tvContador.setText(String.valueOf(totalProductosCarrito));
        }
    }
}
