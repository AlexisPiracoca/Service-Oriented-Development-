package usta.taller_03.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estudianteMateria")
@Getter
@Setter
public class EstudianteMateriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudianteMateria")
    private long idEstudianteMateria;

    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    @ManyToOne(fetch = FetchType.EAGER)

    private EstudianteEntity estudianteEntity;

    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria")
    @ManyToOne(fetch = FetchType.EAGER)

    private MateriaEntity materiaEntity;
}
