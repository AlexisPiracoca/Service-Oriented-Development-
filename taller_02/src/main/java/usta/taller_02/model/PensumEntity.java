package usta.taller_02.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "pensum")
public class PensumEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPensum")
    private long idPensum;

    @NotNull
    @Column(name = "nombrePensum",length = 200)
    private String nombrePensum;

    @NotNull
    @Column(name = "periodoPensum")
    private int periodoPensum;

    @JoinColumn(name = "idPrograma", referencedColumnName = "idPrograma")
    @ManyToOne(fetch = FetchType.EAGER)

    private ProgramaEntity programaEntity;
}
