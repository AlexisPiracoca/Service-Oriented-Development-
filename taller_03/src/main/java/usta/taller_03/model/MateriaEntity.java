package usta.taller_03.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materia")
@Getter
@Setter
public class MateriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateria")
    private long idMateria;

    @NotNull
    @Column(name = "nombre",length = 20)
    private String nombre;

    @NotNull
    @Column(name = "codigo")
    private int codigo;

    @NotNull
    @Column(name = "semestre")
    private int semestre;
}
