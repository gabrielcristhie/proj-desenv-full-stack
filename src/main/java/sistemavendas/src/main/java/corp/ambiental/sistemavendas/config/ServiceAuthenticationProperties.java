package sistemavendas.src.main.java.corp.ambiental.sistemavendas.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties(prefix="application.brk.auth")
@NoArgsConstructor
public class ServiceAuthenticationProperties {
    private String username;    //NOSONAR
    private String password;    //NOSONAR
}
