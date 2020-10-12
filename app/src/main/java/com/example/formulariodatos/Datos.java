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
        btnEditar =(Button)findViewById(R.id.BotonEditar);


        Bundle bundle = this.getIntent().getExtras();
        txtFecha.setText("Fecha: " + bundle.getString("FECHA"));
        txtNombre.setText("Nombre: " + bundle.getString("NOMBRE"));
        txtTelefono.setText("Teléfono: " +bundle.getString("TEL"));
        txtEmail.setText("Email : " + bundle.getString("EMAIL"));
        txtDescripcion.setText("Descripción: " + bundle.getString("DESCRIPCION"));



    }
    public void editar (View view) {
    finish();
    }
}