package com.SAD.domain;

import java.io.File;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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
    @ManyToOne
    public Marca marca;
    
    public String nombre;
    private String descripcion;    
    private String imagen;    
    private double precio;
    private long existencias;
    private boolean activo;
    @Transient
    private String id_marca;
    @Transient
    public MultipartFile file;

    public Producto(Marca marca, String nombre, double precio, long existencias, boolean activo, MultipartFile file) {
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
        this.file = file;
    }
    
    public Producto(){
    }

    public Producto(String nombre, String descripcion, double precio, long existencias, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    public Producto(long idProducto, Marca marca, String nombre, String descripcion, String imagen, double precio, long existencias, boolean activo) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    public Producto(long idProducto, String nombre, String descripcion, String imagen, double precio, long existencias, boolean activo, String id_marca) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
        this.id_marca = id_marca;
        
        
    }

    public Producto(String nombre, String descripcion, String imagen, double precio, long existencias, boolean activo, String id_marca) {
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    public Producto(Marca marca, String nombre, String descripcion, String imagen, double precio, long existencias, boolean activo) {
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
    
}
