package sistemavendas.src.main.java.corp.ambiental.sistemavendas.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/*
 * Configures the console and Logstash log appenders from the app properties
 */
@Configuration
public class LoggingConfig {

    public LoggingConfig(@Value("${spring.application.name}") String appName,
                                @Value("${server.port}") String serverPort,
                                ObjectMapper mapper) throws JsonProcessingException {
    }
}
