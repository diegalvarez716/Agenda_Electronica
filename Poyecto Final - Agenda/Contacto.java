package com.example.agenda;

public class Contacto {
    String nombre, apellido,codigo_de_pais, ciudadania,numero;
    long cedula;
    int codigo_de_area;

    Contacto anterior = null, siguiente = null;

    public Contacto(String nombre, String apellido, String codigo_de_pais, String ciudadania,long cedula, String numero, int codigo_de_area) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo_de_pais = codigo_de_pais;
        this.ciudadania = ciudadania;
        this.cedula = cedula;
        this.numero = numero;
        this.codigo_de_area = codigo_de_area;
    }
}
