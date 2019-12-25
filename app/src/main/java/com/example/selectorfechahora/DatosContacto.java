package com.example.selectorfechahora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatosContacto extends AppCompatActivity implements View.OnClickListener {
Button bEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);
        bEditar = (Button)findViewById(R.id.btnEditar);
       bEditar.setOnClickListener(this);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Contacto");
        String fecha = parametros.getString("Fecha");
        String telefono = parametros.getString("Telefono");
        String correo = parametros.getString("Correo");
        String descripcion = parametros.getString("Describe");

        TextView tnombre = (TextView) findViewById(R.id.tvNombre);
        EditText efecha = (EditText) findViewById(R.id.etFecha1);
        EditText eTelefono = (EditText) findViewById(R.id.etTelefono1);
        EditText eCorreo = (EditText) findViewById(R.id.etEmail1);
        EditText eDescribe = (EditText) findViewById(R.id.etDescripcion1);
       tnombre.setText(nombre);
       efecha.setText(fecha);
       eTelefono.setText(telefono);
       eCorreo.setText(correo);
       eDescribe.setText(descripcion);
    }

    @Override
    public void onClick(View v) {
    if (v==bEditar){
      /* Intent regresar =new Intent(this, MainActivity.class);
       regresar.putExtra("Contacto",tnombre.getText().toString());
        regresar.putExtra("Fecha",efecha.getText().toString());
        regresar.putExtra("Telefono",eTelefono.getText().toString());
        regresar.putExtra("Correo",eCorreo.getText().toString());
        regresar.putExtra("Describe",eDescribe.getText().toString());
        startActivity(regresar);
       super.onDestroy();*/
      finish();
         }
    }
}
