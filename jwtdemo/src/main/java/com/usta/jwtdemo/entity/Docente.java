package com.usta.jwtdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="docentes")
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_docente")
    private Long codDocente;

    @Column(name ="documento_docente")
    private String documentoDocente;

    @Column(name ="nombres_docente")
    private String nombresDocente;

    @Column(name ="apellidosDocente")
    private String apellidosDocente;

    @JoinColumn(name="cod_facultad", referencedColumnName = "cod_facultad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Facultad idFacultad;

    @JoinColumn(name="id_usuario", referencedColumnName = "iduser")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario idUsuario;

    public Docente() {

    }

    public Docente(Long codDocente, String documentoDocente, String nombresDocente, String apellidosDocente, Facultad idFacultad, Usuario idUsuario) {
        this.codDocente = codDocente;
        this.documentoDocente = documentoDocente;
        this.nombresDocente = nombresDocente;
        this.apellidosDocente = apellidosDocente;
        this.idFacultad = idFacultad;
        this.idUsuario = idUsuario;
    }

    public Long getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Long codDocente) {
        this.codDocente = codDocente;
    }

    public String getDocumentoDocente() {
        return documentoDocente;
    }

    public void setDocumentoDocente(String documentoDocente) {
        this.documentoDocente = documentoDocente;
    }

    public String getNombresDocente() {
        return nombresDocente;
    }

    public void setNombresDocente(String nombresDocente) {
        this.nombresDocente = nombresDocente;
    }

    public String getApellidosDocente() {
        return apellidosDocente;
    }

    public void setApellidosDocente(String apellidosDocente) {
        this.apellidosDocente = apellidosDocente;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
