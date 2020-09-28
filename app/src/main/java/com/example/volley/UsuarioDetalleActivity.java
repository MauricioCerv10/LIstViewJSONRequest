package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UsuarioDetalleActivity extends AppCompatActivity {
    TextView mDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle);
        mDetalle = findViewById(R.id.textView);
        Usuario usuarioDetalle = getIntent().getExtras().getParcelable(MiAdaptador.EXTRA);
        if(usuarioDetalle != null)
            mDetalle.setText(usuarioDetalle.toString());


    }
}