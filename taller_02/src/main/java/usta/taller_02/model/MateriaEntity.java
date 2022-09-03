package usta.taller_02.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "materia")
public class MateriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateria")
    private long idMateria;

    @NotNull
    @Column(name = "nombreMateria",length = 200)
    private String nombreMateria;

    @NotNull
    @Column(name = "referenciaMateria",length = 200)
    private String referenciaMateria;
}
