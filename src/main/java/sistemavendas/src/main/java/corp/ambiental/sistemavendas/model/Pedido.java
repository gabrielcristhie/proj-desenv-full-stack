package sistemavendas.src.main.java.corp.ambiental.sistemavendas.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Pedido")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Validated
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pedido")
    private long idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente", referencedColumnName = "id_Cliente")
    private ClientePF clientePF;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente", referencedColumnName = "id_Cliente")
    private ClientePJ clientePJ;

    @Column(name = "status_Pedido")
    private StatusPedido statusPedido;
}
