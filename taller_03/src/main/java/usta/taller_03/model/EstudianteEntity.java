package usta.taller_03.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class EstudianteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private long idEstudiante;

    @NotNull
    @Column(name = "nombre",length = 50)
    private String nombre;

    @NotNull
    @Column(name = "primerApellido",length = 50)
    private String primerApellido;

    @NotNull
    @Column(name = "segundoApellido",length = 50)
    private String segundoApellido;

    @NotNull
    @Column(name = "documento",length = 13)
    private String documento;

    @JoinColumn(name = "idFacultad", referencedColumnName = "idFacultad")
    @ManyToOne(fetch = FetchType.EAGER)

    private FacultadEntity facultadEntity;

}
