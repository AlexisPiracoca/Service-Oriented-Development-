package com.usta.jwtdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="facultades")
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_facultad")
    private Long codFacultad;

    @Column(name ="nombre_facultad")
    private String nombreFacultad;

    public Facultad() {

    }

    public Facultad(Long codFacultad, String nombreFacultad) {
        this.codFacultad = codFacultad;
        this.nombreFacultad = nombreFacultad;
    }
    
    public Long getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Long codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }
}
