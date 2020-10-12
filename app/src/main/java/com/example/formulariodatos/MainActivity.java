package com.example.formulariodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    EditText eNombre;
    EditText eTel;
    EditText eMail;
    EditText eDescripcion;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre =(EditText) findViewById(R.id.Nombre);
        eTel =(EditText) findViewById(R.id.tel);
        eMail =(EditText) findViewById(R.id.email);
        eDescripcion =(EditText) findViewById(R.id.descripcion);
        eText =(EditText) findViewById(R.id.fecha);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btn=(Button)findViewById(R.id.BotonSiguiente);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent (MainActivity.this, Datos.class);

               Bundle b = new Bundle();
               b.putString("FECHA", eText.getText().toString());
               b.putString("NOMBRE",eNombre.getText().toString());
               b.putString("TEL", eTel.getText().toString());
               b.putString("EMAIL", eMail.getText().toString());
               b.putString("DESCRIPCION", eDescripcion.getText().toString());
               intent.putExtras(b);
                startActivity(intent);

            }

        });

    Bundle bundle = this.getIntent().getExtras();
        eText.setText(bundle.getString("FECHA"));
        eNombre.setText(bundle.getString("NOMBRE"));
        eTel.setText(bundle.getString("TEL"));
        eMail.setText(bundle.getString("EMAIL"));
        eDescripcion.setText(bundle.getString("DESCRIPCION"));

    }
}