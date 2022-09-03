package usta.universidad.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "docente")
public class DocenteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocente")
    private long idDocente;

    @NotNull
    @Column(name = "documentoDocente",length = 200)
    private String documentoDocente;

    @NotNull
    @Column(name = "nombresDocente",length = 200)
    private String nombresDocente;

    @NotNull
    @Column(name = "apellidosDocente",length = 200)
    private String apellidosDocente;

    @NotNull
    @Column(name = "tipoDocente")
    private int tipoDocente;

    @JoinColumn(name = "idFacultad", referencedColumnName = "idFacultad")
    @ManyToOne(fetch = FetchType.EAGER)

    private FacultadEntity facultadEntity;
}
