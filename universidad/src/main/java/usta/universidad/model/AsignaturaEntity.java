package usta.universidad.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "asignatura")
public class AsignaturaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsignatura")
    private long idAsignatura;

    @NotNull
    @Column(name = "semestreAsignatura")
    private int semestreAsignatura;

    @NotNull
    @Column(name = "nombreAsignatura",length = 200)
    private String nombreAsignatura;

    @NotNull
    @Column(name = "codigoAsignatura")
    private int codigoAsignatura;

    @NotNull
    @Column(name = "tipoAsignatura",length = 200)
    private String tipoAsignatura;

    @JoinColumn(name = "idDocente", referencedColumnName = "idDocente")
    @ManyToOne(fetch = FetchType.EAGER)

    private DocenteEntity docenteEntity;

}
