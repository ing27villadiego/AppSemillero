package com.example.lamaquina.pruebaloggin1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText EtNombre, EtApellido, EtNombreUsuario, EtContraseña;
    Button BtnRegistrar, BtnSalirRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        EtNombre = (EditText) findViewById(R.id.EtNombre);
        EtApellido = (EditText) findViewById(R.id.EtApellido);
        EtNombreUsuario = (EditText) findViewById(R.id.EtNombreUsuario);
        EtContraseña = (EditText) findViewById(R.id.EtConstraseña);

        BtnRegistrar = (Button) findViewById(R.id.BtnRegistrar);
        BtnSalirRegistro = (Button) findViewById(R.id.BtnSalirRegistro);

        BtnRegistrar.setOnClickListener(this);
        BtnSalirRegistro.setOnClickListener(this);

    }

    public void guardarDatos(View view){
        String Nombre = EtNombre.getText().toString();
        String Apellido = EtApellido.getText().toString();
        String NombreUsuario = EtNombreUsuario.getText().toString();
        String Contraseña = EtContraseña.getText().toString();

    }

    private void showMensajeError(){
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(RegistroUsuario.this);
        dialogoBuilder.setMessage("aprovecha puedes entrar gratis, aun no necesita registro. jajaja");
        dialogoBuilder.setPositiveButton("Aceptar", null);
        dialogoBuilder.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnRegistrar:
                showMensajeError();
                startActivity(new Intent(RegistroUsuario.this, VentanaInicial.class));
                break;

            case R.id.BtnSalirRegistro:
                startActivity(new Intent(RegistroUsuario.this, Loggin.class));
                break;
        }
    }
}
