package usta.universidad.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "facultad")
public class FacultadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFacultad")
    private long idFacultad;

    @NotNull
    @Column(name = "nombreFacultad",length = 200)
    private String nombreFacultad;

    @JoinColumn(name = "idSeccional", referencedColumnName = "idSeccional")
    @ManyToOne(fetch = FetchType.EAGER)

    private SeccionalEntity seccionalEntity;
}
