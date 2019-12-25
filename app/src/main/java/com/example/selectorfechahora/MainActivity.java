package com.example.selectorfechahora;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bSiguiente, bHora;
    EditText eFecha, eDescribe,eNombre,eEmail,eTelefono;
    private int dia,mes,ano,horas,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bSiguiente=(Button)findViewById(R.id.btnSiguiente);

        eFecha=(EditText)findViewById(R.id.etFecha);
        eNombre=(EditText)findViewById(R.id.etNombre) ;
        eEmail=(EditText)findViewById(R.id.etEmail) ;
        eDescribe=(EditText)findViewById(R.id.etDescripcion);
        eTelefono=(EditText) findViewById(R.id.etTelefono);

        eFecha.setOnClickListener(this);
        bSiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==eFecha){
            final Calendar c =Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            dia=c.get((Calendar.MONTH));
            dia=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }

        if(v==bSiguiente){
            Intent intent = new Intent(MainActivity.this,DatosContacto.class);
            intent.putExtra("Contacto",eNombre.getText().toString());
            intent.putExtra("Fecha",eFecha.getText().toString());
            intent.putExtra("Telefono",eTelefono.getText().toString());
            intent.putExtra("Correo",eEmail.getText().toString());
            intent.putExtra("Describe",eDescribe.getText().toString());
            startActivity(intent);
        }
    }
}
