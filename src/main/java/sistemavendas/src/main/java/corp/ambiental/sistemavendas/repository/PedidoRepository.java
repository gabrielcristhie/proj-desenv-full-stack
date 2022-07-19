package sistemavendas.src.main.java.corp.ambiental.sistemavendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemavendas.src.main.java.corp.ambiental.sistemavendas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
