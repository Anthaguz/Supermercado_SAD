package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    public long idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private int telefono;

    public Cliente(long idCliente, String nombre, String apellido, String correo, String direccion, int telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion=direccion;
        this.telefono = telefono;
    }

}
