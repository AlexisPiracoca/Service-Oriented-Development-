package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pagos")
@Getter
@Setter
public class PagosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private long idPago;

    @NotNull
    @Column(name = "tipoPago",length = 100)
    private String tipoPago;
}
