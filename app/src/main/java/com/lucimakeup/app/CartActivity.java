package com.lucimakeup.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView tvResumen = findViewById(R.id.tvResumenItemsCarrito);
        TextView tvTotal = findViewById(R.id.tvTotalPagar);
        Button btnPago = findViewById(R.id.btnIrAEnvio);

        tvResumen.setText("• Base Líquida Matte HD (" + CatalogActivity.totalProductosCarrito + " un)");
        tvTotal.setText("$ " + CatalogActivity.subtotalCarrito + " COP");

        btnPago.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });
    }
}
