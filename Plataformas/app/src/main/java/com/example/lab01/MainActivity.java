package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button action;
    EditText name,lastName,codigo, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.edit_name);
        lastName = (EditText)findViewById(R.id.edit_LastName);
        codigo = (EditText)findViewById(R.id.edit_Code);
        correo = (EditText)findViewById(R.id.edit_Email);
        action = (Button) findViewById(R.id.button_Send);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                lastName.setText("");
                correo.setText("");
                codigo.setText("");
                Toast t1 = Toast.makeText(getApplicationContext(), "Alumno registrado", Toast.LENGTH_SHORT);
                t1.show();

            }
        });
    }
}
