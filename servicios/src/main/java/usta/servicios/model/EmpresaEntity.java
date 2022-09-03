package usta.servicios.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "empresa")
public class EmpresaEntity implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private long idempresa;

    @NotNull
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @NotNull
    @Column(name = "nit")
    private String nit;

    @NotNull
    @Column(name = "codigo")
    private int codigo;

}
