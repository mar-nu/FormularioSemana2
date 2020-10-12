package com.example.formulariodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    TextView txtNombre;
    TextView txtFecha;
    TextView txtTelefono;
    TextView txtEmail;
    TextView txtDescripcion;
    Button  btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);



        txtFecha = (TextView)findViewById(R.id.FechaIngresada);
        txtNombre = (TextView)findViewById(R.id.NombreIngresado);
        txtTelefono = (TextView)findViewById(R.id.TelefonoIngresado);
        txtEmail = (TextView)findViewById(R.id.EmailIngresado);
        txtDescripcion = (TextView)findViewById(R.id.DescripcionIngresada);


        Bundle bundle = this.getIntent().getExtras();
        txtFecha.setText(bundle.getString("FECHA"));
        txtNombre.setText(bundle.getString("NOMBRE"));
        txtTelefono.setText(bundle.getString("TEL"));
        txtEmail.setText(bundle.getString("EMAIL"));
        txtDescripcion.setText(bundle.getString("DESCRIPCION"));

        btnEditar =(Button)findViewById(R.id.BotonEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent intent = new Intent(Datos.this, MainActivity.class);

                Bundle b = new Bundle();
                b.putString("FECHA", txtFecha.getText().toString());
                b.putString("NOMBRE", txtNombre.getText().toString());
                b.putString("TEL", txtTelefono.getText().toString());
                b.putString("EMAIL", txtEmail.getText().toString());
                b.putString("DESCRIPCION", txtDescripcion.getText().toString());
                intent.putExtras(b);
                startActivity(intent);

            }
    });
    }
}