package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_producto")
    private long idProducto;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @OneToMany
    private long idMarca;
    private String nombre;
    private String descripcion;    
    private String imagen;    
    private double precio;
    private long existencias;
    private boolean activo;
    @Transient
    private long id_marca;
    public Producto(){
    }

    public Producto(String nombre, String descripcion, double precio, long existencias, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
}
