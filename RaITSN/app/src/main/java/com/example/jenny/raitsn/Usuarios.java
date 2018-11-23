package com.example.jenny.raitsn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Usuarios extends Activity {
    private String array_spinner[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        array_spinner=new String[3];
        array_spinner[0]=" ";
        array_spinner[1]="Solicitante";
        array_spinner[2]="Prestador de servicio";
        Spinner s = (Spinner) findViewById(R.id.spinnerUsu);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
    }

    public void onClickAceptarUsu(View view) {

        if(array_spinner[1].equals("Solicitante"))
        {
            //Primeramente debe llevar al mapa para ingesar la ubicacion y destino
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
        if(array_spinner[2].equals("Prestador de servicio"))
        {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }

    }

}
