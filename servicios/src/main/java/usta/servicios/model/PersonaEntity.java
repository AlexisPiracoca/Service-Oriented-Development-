package usta.servicios.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "persona")
public class PersonaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private long idpersona;

    @NotNull
    @Column(name = "nombres")
    private String nombres;

    @NotNull
    @Column(name = "apellidos")
    private String apellidos;

    @NotNull
    @Column(name = "documento")
    private String documento;

    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @ManyToOne(fetch = FetchType.EAGER)

    private EmpresaEntity empresaEntity;

}
