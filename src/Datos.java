/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MariaSalas
 */

import java.io.Serializable;
/**
 *
 */
public class Datos implements Serializable{
    private long id; //100
    private String codigo;//PRODUCTXXX1
    private String nombre;
    private float precio;
    private int stock;

    public Datos(long id, String codigo, String nombre, float precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.nombre.toUpperCase();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void vender(int numero){
//      this.stock=this.stock-numero;
        this.stock-=numero;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
