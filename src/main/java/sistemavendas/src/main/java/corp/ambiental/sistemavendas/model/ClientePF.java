package sistemavendas.src.main.java.corp.ambiental.sistemavendas.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cliente_PF")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Validated
public class ClientePF extends Cliente{

    @Column(name = "cpf")
    private long cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientePF", orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Pedido> pedidos = new HashSet<>();

    @Override
    public String getTelefoneFormatado() {
        return null;
    }
}
