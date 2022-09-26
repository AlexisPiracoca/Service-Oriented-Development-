package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estatus")
@Getter
@Setter
public class EstatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstatus")
    private long idEstatus;

    @NotNull
    @Column(name = "nombreEstatus")
    private int nombreEstatus;
}
