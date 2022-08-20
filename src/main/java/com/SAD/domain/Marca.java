package com.SAD.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Marca")
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    public long idMarca;
    public String nombre;
    public String proveedor;

    public Marca(long idMarca, String nombre, String proveedor) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.proveedor = proveedor;
    }

    public Marca() {
    }
    
}
