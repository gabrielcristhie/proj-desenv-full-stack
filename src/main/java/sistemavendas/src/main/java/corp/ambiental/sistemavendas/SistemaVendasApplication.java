package sistemavendas.src.main.java.corp.ambiental.sistemavendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sistemavendas.src.main.java.corp.ambiental.sistemavendas.config.ServiceAuthenticationProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({ServiceAuthenticationProperties.class})
public class SistemaVendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
	}
}
