package com.example.tl01examen2902.tablas;

public class Contactos {
    private Integer id;
    private String nombre;
    private Integer telefono;
    private String pais;
    private String acerca;

    public Contactos(Integer id, String nombre, Integer telefono, String pais, String acerca) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pais = pais;
        this.acerca = acerca;
    }

    public Contactos() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }
}
