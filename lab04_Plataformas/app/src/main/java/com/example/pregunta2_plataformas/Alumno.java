package com.example.pregunta2_plataformas;

import android.widget.ArrayAdapter;

public class Alumno {

    private String CUI;
    private String nombre;
    private String apellido;

    Alumno(String nombre, String apellido, String CUI){
        this.CUI = CUI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCUI(){
        return CUI;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setCUI(String aux){
        CUI = aux;
    }
    public void setNombre(String aux){
        nombre = aux;
    }
    public void setApellido(String aux){
        apellido = aux;
    }

    public String getString(){
        return nombre+"            "+apellido+"            " + CUI;
    }
}
