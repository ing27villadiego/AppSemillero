package com.example.lamaquina.pruebaloggin1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Loggin extends AppCompatActivity implements View.OnClickListener {
    EditText EtNombreUsuario, EtContraseña;
    Button BtnInicioSesion;
    TextView TvRegistrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        EtNombreUsuario = (EditText) findViewById(R.id.EtNombreUsuario);
        EtContraseña = (EditText) findViewById(R.id.EtConstraseña);

        BtnInicioSesion = (Button) findViewById(R.id.BtnInicioSesion);

        TvRegistrate = (TextView) findViewById(R.id.TvRegistrate);

        BtnInicioSesion.setOnClickListener(this);
        TvRegistrate.setOnClickListener(this);
    }

    private void showMensajeError(){
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(Loggin.this);
        dialogoBuilder.setMessage("aprovecha puedes entrar gratis, aun no necesita registro. jajaja");
        dialogoBuilder.setPositiveButton("Aceptar", null);
        dialogoBuilder.show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnInicioSesion:
                showMensajeError();
                startActivity(new Intent(this, VentanaInicial.class));
                break;

            case R.id.TvRegistrate:
                startActivity(new Intent(this, RegistroUsuario.class));
                break;
        }
    }
}
