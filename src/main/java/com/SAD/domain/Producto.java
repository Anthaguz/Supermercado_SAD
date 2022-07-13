package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Producto implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idProducto;
    private String name;
    private String descripcion;
    private String marca;
    private double precio;
    private long existencias;
    private boolean activo;
    
    public Producto(){
    }

    public Producto(String name, String descripcion, String marca, double precio, long existencias, boolean activo) {
        this.name = name;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
    
}
