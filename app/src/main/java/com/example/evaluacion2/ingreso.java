//Juan Eduardo Clemente Chávez

package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ingreso extends AppCompatActivity {
    //Creamos las variables que trabajarán con los id de esta pantalla
    EditText coordenada1;
    EditText coordenada2;
    EditText coordenada3;
    TextView cambio;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        cambio = findViewById(R.id.txtViewCambio);

        //Asignamos las coordenadas
        coordenada1 = findViewById(R.id.txtCoordenada1);
        coordenada2 = findViewById(R.id.txtCoordenada2);
        coordenada3 = findViewById(R.id.txtCoordenada3);

        //Asignamos el botón
        agregar = findViewById(R.id.bttnAgregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Guardamos los datos de las coordenadas en un nuevo String
                    String coord1 = coordenada1.getText().toString();
                    String coord2 = coordenada2.getText().toString();
                    String coord3 = coordenada3.getText().toString();

                    //Pasamos el string como array para poder separar el texto con una coma, esto con la palabra reservada .split()
                    String[] coord1Array = coord1.split(",");
                    String[] coord2Array = coord2.split(",");
                    String[] coord3Array = coord3.split(",");

                    //Si las 3 direcciones están escritas, entrará en el IF
                    if ((coord1Array.length == 2) && (coord2Array.length == 2) && (coord3Array.length == 2)) {
                        //Guardamos las latitudes y longitudes como double.
                        double latitud1 = Double.parseDouble(coord1Array[0]);
                        double longitud1 = Double.parseDouble(coord1Array[1]);

                        double latitud2 = Double.parseDouble(coord2Array[0]);
                        double longitud2 = Double.parseDouble(coord2Array[1]);

                        double latitud3 = Double.parseDouble(coord3Array[0]);
                        double longitud3 = Double.parseDouble(coord3Array[1]);

                        // Creación de un Intent para pasar los datos a la actividad maps
                        Intent intent = new Intent(getApplicationContext(), maps.class);
                        intent.putExtra("lat1", latitud1);
                        intent.putExtra("long1", longitud1);
                        intent.putExtra("lat2", latitud2);
                        intent.putExtra("long2", longitud2);
                        intent.putExtra("lat3", latitud3);
                        intent.putExtra("long3", longitud3);
                        startActivity(intent);
                    } else {
                        //Las coordenadas no se ingresaron correctamente
                        cambio.setText("Formato de coordenadas incorrecto, inténtelo de nuevo");
                        cambio.setTextColor(Color.RED);
                    }
                } catch (NumberFormatException e) {
                    //Las coordenadas no sean números válidos
                    cambio.setText("Las coordenadas ingresadas no son números válidos, inténtelo de nuevo");
                    cambio.setTextColor(Color.RED);
                }
            }
        });
    }
}