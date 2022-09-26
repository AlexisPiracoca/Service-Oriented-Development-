package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicos")
@Getter
@Setter
public class MedicosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedico")
    private long idMedico;

    @NotNull
    @Column(name = "nombres",length = 50)
    private String nombres;

    @NotNull
    @Column(name = "primerApellido",length = 15)
    private String primerApellido;

    @NotNull
    @Column(name = "segundoApellido",length = 15)
    private String segundoApellido;

    @NotNull
    @Column(name = "genero")
    private int genero;

    @NotNull
    @Column(name = "email",length = 15)
    private String email;

    @NotNull
    @Column(name = "telefono",length = 15)
    private String telefono;

    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(fetch = FetchType.EAGER)

    private CategoriasEntity categoriasEntity;

}
