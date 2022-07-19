package sistemavendas.src.main.java.corp.ambiental.sistemavendas.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("sistemavendas.src.main.java.corp.ambiental.sistemavendas.repository")
@EnableTransactionManagement
public class DatabaseConfig {
    private final Environment env;

    public DatabaseConfig(Environment env) {
        this.env = env;
    }
}
