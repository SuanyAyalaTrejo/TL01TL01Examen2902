package com.example.tl01examen2902.tablas;

public class Contactos {
    private Integer id;

    private String pais;
    private String nombre;
    private Integer telefono;

    private String acerca;

    public Contactos( String pais, String nombre, Integer telefono, String acerca) {

        this.pais = pais;
        this.nombre = nombre;
        this.telefono = telefono;
        this.acerca = acerca;
    }

    public Contactos() {}




    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }
}
