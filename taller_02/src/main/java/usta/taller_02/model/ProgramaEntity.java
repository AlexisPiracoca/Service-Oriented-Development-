package usta.taller_02.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "programa")
public class ProgramaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrograma")
    private long idPrograma;

    @NotNull
    @Column(name = "nombrePrograma",length = 200)
    private String nombrePrograma;

}
