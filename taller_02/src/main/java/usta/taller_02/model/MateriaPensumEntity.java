package usta.taller_02.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "materiapensum")
public class MateriaPensumEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateriaPensum")
    private long idMateriaPensum;

    @JoinColumn(name = "idSemestre", referencedColumnName = "idSemestre")
    @ManyToOne(fetch = FetchType.EAGER)

    private SemestreEntity semestreEntity;

    @JoinColumn(name = "idPensum", referencedColumnName = "idPensum")
    @ManyToOne(fetch = FetchType.EAGER)

    private PensumEntity pensumEntity;

    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria")
    @ManyToOne(fetch = FetchType.EAGER)

    private MateriaEntity materiaEntity;
}
