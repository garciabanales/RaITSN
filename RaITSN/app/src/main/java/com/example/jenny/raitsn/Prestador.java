package com.example.jenny.raitsn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Prestador extends Activity {
    private EditText ubicacion2;
    private EditText destino2;
    private EditText hora2;
    private EditText descrip;
    private EditText costo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador);

        ubicacion2=(EditText)findViewById(R.id.etUbicacionP);
        destino2=(EditText)findViewById(R.id.etDestinoP);
        hora2=(EditText)findViewById(R.id.etHoraP);
        descrip=(EditText)findViewById(R.id.etDescrip);
        costo=(EditText)findViewById(R.id.etcosto);
    }
    public void onClickConfP(View view) {


    }
    public void onClickCancelarP(View view) {


    }

}
