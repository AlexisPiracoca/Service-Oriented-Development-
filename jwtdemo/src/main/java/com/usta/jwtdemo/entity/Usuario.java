package com.usta.jwtdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long iduser;

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="estado")
    private boolean estado;

    public Usuario() {

    }

    public Usuario(Long iduser, String username, String password, boolean estado) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.estado = estado;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
