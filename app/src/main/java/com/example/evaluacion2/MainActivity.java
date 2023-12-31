//Juan Eduardo Clemente Chávez

package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        // Cuando se inicializa el splash, espera 3 segundos para ir a la siguiente actividad
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        getApplicationContext(), ingreso.class
                );
                startActivity(intent);
                finish();
            }
        },3000);
    }
}