/* Clase Articulo que me servira para complatilla para crear un arreglo de Tipo Articulo esta clase contiene sus respectivos atributos y los get y set de estos, para asi poder ser llamados desde un objeto creado de este tipo
 * Nombre: Cristian Martin Moreno Rodriguez
 * Fecha: 1/abril/2021*/
package com.evaluacionarreglos;

public class Articulo{
    
    private int id;
    private String nombre;
    private String modelo;
    private int precio;
    private int existencia;

    public Articulo(){
        this.id= 0;
        this.nombre= null;
        this.modelo= null;
        this.precio= 0;
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

    public void setPrecio(int val){
        this.precio= val;
    }

    public int getPrecio(){
        return this.precio;
    }

    public void setExistencia(int val){
        this.existencia= val;
    }

    public int getExistencia(){
        return this.existencia;
    }
}
