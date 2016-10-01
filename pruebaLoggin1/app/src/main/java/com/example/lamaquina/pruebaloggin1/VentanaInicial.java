package com.example.lamaquina.pruebaloggin1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VentanaInicial extends AppCompatActivity {
    TextView txtEntrada, txtSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_inicial);

        ImageButton reconoce=(ImageButton) findViewById(R.id.imageButton);
        txtEntrada = (TextView) findViewById(R.id.TextoEntrada);
        txtSalida = (TextView) findViewById(R.id.TextoSalida);
        reconoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                try{
                    startActivityForResult(intent, 1);

                }catch (ActivityNotFoundException a){
                    Toast.makeText(getApplicationContext(), "No soporta",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onActivityResult(int requestcode, int resultcode, Intent datos){
        if (resultcode== Activity.RESULT_OK && datos!=null){
            ArrayList<String> text = datos.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if(txtEntrada.getText().equals("Texto de entrada")){
                txtEntrada.setText(text.get(0));
            }
            if(text.get(0).equals("enviar") && !txtEntrada.getText().equals("Texto de entrada")){
                txtSalida.setText(txtEntrada.getText());
                txtEntrada.setText("Texto de entrada");
            }
            //Toast.makeText(this,text.get(0),Toast.LENGTH_LONG).show();
        }
    }

}
