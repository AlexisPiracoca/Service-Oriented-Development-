package usta.taller_04_crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuariosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private long idUsuario;

    @NotNull
    @Column(name = "username",length = 10)
    private String username;

    @NotNull
    @Column(name = "password",length = 10)
    private String password;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    @OneToOne(mappedBy = "usuarios")
    @JsonIgnore
    private PacientesEntity pacientesEntity;
}
