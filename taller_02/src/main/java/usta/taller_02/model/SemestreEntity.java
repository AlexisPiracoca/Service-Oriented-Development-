package usta.taller_02.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "semestre")
public class SemestreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSemestre")
    private long idSemestre;

    @NotNull
    @Column(name = "nombreSemestre",length = 200)
    private String nombreSemestre;
}
