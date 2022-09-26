package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class CategoriasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private long idCategoria;

    @NotNull
    @Column(name = "nombreCategoria",length = 100)
    private String nombreCategoria;
}
