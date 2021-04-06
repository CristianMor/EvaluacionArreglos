package com.evaluacionarreglos;

public class Articulo{
    
    private int id;
    private String nombre;
    private String modelo;
    private double precio;
    private int existencia;

    public Articulo(){
        this.id= 0;
        this.nombre= null;
        this.modelo= null;
        this.precio= 0.0;
        this.existencia= 0;
    }

    public void setId(int val){
        this.id= val;
    }

    public int getId(){
        return this.id;
    }

    public void setNombre(String val){
        this.nombre= val;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setModelo(String val){
        this.modelo= val;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setPrecio(double val){
        this.precio= val;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setExistencia(int val){
        this.existencia= val;
    }

    public double getExistencia(){
        return this.existencia;
    }
}
