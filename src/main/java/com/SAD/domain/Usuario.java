package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private int telefono;
    Long idCliente;
    Long idRol;
    String username;
    String password;

    public Usuario(long idUsuario, String nombre, String apellido, String correo, String direccion, int telefono, Long idCliente, Long idRol, String username, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCliente = idCliente;
        this.idRol = idRol;
        this.username = username;
        this.password = password;
    }



    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
}
