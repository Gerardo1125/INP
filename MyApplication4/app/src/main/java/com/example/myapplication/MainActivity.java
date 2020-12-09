package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";
    FirebaseFirestore db;
    Button b,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        m = (Button) findViewById(R.id.button_mostrar);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearColeccion();
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MostrarDatos.class));
            }
        });
    }

    public void crearColeccion(){
        Map<String, Object> map = new HashMap<>();
        Calendar calendario = Calendar.getInstance();
        Date date = new Date();
        map.put("fecha", date.getDay()+"/"+date.getMonth()+"/"+date.getYear());
        map.put("hora",calendario.get(Calendar.HOUR_OF_DAY)+ ":"+calendario.get(Calendar.MINUTE)+ ":"+calendario.get(Calendar.SECOND));
        map.put("latitud",2134564);
        map.put("longitud",12341564);
        map.put("velocidad",5);
        db.collection("Trayectoria").document().set(map);
    }
}