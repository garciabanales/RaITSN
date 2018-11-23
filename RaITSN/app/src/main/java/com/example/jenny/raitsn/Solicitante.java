package com.example.jenny.raitsn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Solicitante extends Activity {
    private EditText ubicacion;
    private EditText destino;
    private EditText hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante);

        ubicacion=(EditText)findViewById(R.id.etUbicacionS);
        destino=(EditText)findViewById(R.id.etDestinoS);
        hora=(EditText)findViewById(R.id.etHoraS);

    }

    public void onClickConfS(View view) {


    }

    public void onClickCancelarS(View view) {


    }





}
