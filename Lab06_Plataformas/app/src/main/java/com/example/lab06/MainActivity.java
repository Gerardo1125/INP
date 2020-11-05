package com.example.lab06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnfr1, btnfr2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr1 fragmento1 =  new fr1();


        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento1);
        btnfr1 = (Button) findViewById(R.id.ahora);
        btnfr2 = (Button) findViewById(R.id.estad);

        btnfr2.setOnClickListener(this);
        btnfr1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ahora:
                fr1 fragmento1 = new fr1();
                FragmentTransaction transicion = getSupportFragmentManager().beginTransaction();
                transicion.replace(R.id.contenedor, fragmento1);
                transicion.commit();
                break;

            case R.id.estad:
                fr2 fragmento2 = new fr2();
                FragmentTransaction transicion2 = getSupportFragmentManager().beginTransaction();
                transicion2.replace(R.id.contenedor, fragmento2);
                transicion2.commit();
                break;
        }
    }
}