package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    String username;
    String password;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @OneToOne
    public Cliente cliente;
    public Long idRol;
    @Transient
    public String nombre;
    @Transient
    public String apellido;
    @Transient
    public String correo;
    @Transient
    public String direccion;
    @Transient
    public int telefono;

    public Usuario() {
    }

    public Usuario(String username, String password, long idRol) {
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public Usuario(Long idUsuario, String username, String password, Cliente cliente, Long idRol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.cliente = cliente;
        this.idRol = idRol;
    }

    public Usuario(Long idUsuario, String username, String password, Cliente cliente, Long idRol, String nombre, String apellido, String correo, String direccion, int telefono) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.cliente = cliente;
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
