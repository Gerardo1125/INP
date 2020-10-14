package com.example.pregunta2_plataformas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    private ListView listAlumnos;
    public Button agregar;
    public ArrayList<Alumno> lista_alumnos= new ArrayList<Alumno>();
    public List<String> alumnos = new ArrayList<>();
    private ArrayAdapter<String> adapter_alumnos;
    private int posicion=0;
    public String flag = "a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlumnos = (ListView)findViewById(R.id.list_alumno);
        listAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posicion = position;
                Intent a = new Intent(MainActivity.this,ThirdActivity.class);
                System.out.println(posicion);
                System.out.println(lista_alumnos.get(position).getNombre());
                a.putExtra("NAME",lista_alumnos.get(position).getNombre());
                a.putExtra("LASTNAME",lista_alumnos.get(position).getApellido());
                a.putExtra("CUI",lista_alumnos.get(position).getCUI());

                startActivityForResult(a,2);
            }
        });
        agregar = (Button)findViewById(R.id.button_add);

        agregar.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode);
        if(data == null){

        }else{
            if(requestCode==1)
            {
                if(data.getStringExtra("NAME").equals("") || data.getStringExtra("LASTNAME").equals("")||data.getStringExtra("CUI").equals("")){

                }else{
                    //String message=data.getStringExtra("MESSAGE");
                    Alumno aux = new Alumno(data.getStringExtra("NAME"),data.getStringExtra("LASTNAME"),data.getStringExtra("CUI"));
                    alumnos.add(aux.getString());
                    lista_alumnos.add(aux);
                    adapter_alumnos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alumnos);
                    listAlumnos.setAdapter(adapter_alumnos);
                }
            }else if (requestCode==2){
                Alumno aux = new Alumno(data.getStringExtra("NAME"),data.getStringExtra("LASTNAME"),data.getStringExtra("CUI"));
                alumnos.set(posicion,aux.getString());
                lista_alumnos.set(posicion,aux);
                adapter_alumnos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alumnos);
                listAlumnos.setAdapter(adapter_alumnos);
            }
        }

        // check if the request code is same as what is passed  here it is 2

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:{
                Intent i = new Intent(this, SecondActivity.class);
                startActivityForResult(i, 1);
            }
        }
    }
}
