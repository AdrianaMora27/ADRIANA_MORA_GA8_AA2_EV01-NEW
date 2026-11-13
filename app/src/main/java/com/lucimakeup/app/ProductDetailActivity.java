package com.lucimakeup.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailActivity extends Activity {
    private int cantidad = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView tvCantidad = findViewById(R.id.tvCantidadItem);
        Button btnMenos = findViewById(R.id.btnMenosCant);
        Button btnMas = findViewById(R.id.btnMasCant);
        Button btnAniadir = findViewById(R.id.btnAniadirCarritoDetalle);
        Button btnVolver = findViewById(R.id.btnVolverCatalogo);

        btnVolver.setOnClickListener(v -> finish());

        btnMenos.setOnClickListener(v -> {
            if (cantidad > 1) {
                cantidad--;
                tvCantidad.setText(String.valueOf(cantidad));
            }
        });

        btnMas.setOnClickListener(v -> {
            cantidad++;
            tvCantidad.setText(String.valueOf(cantidad));
        });

        btnAniadir.setOnClickListener(v -> {
            CatalogActivity.totalProductosCarrito += cantidad;
            CatalogActivity.subtotalCarrito += (45000 * cantidad);
            Toast.makeText(this, "¡" + cantidad + " producto(s) añadidos al carrito!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
