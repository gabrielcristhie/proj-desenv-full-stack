package sistemavendas.src.main.java.corp.ambiental.sistemavendas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.*;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfig implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfig.class);

    private final Environment env;

    public WebConfig(Environment env) {
        this.env = env;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if(env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }
        log.info("Web application fully configured");
    }

    @Bean
    public CorsFilter corsFilter() throws NullPointerException {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));

        List<String> allowedOrigins = configuration.getAllowedOrigins();

        if(allowedOrigins != null && !allowedOrigins.isEmpty()) {
            log.debug("Registering CORS filter");
            source.registerCorsConfiguration("/api/**", configuration);
            source.registerCorsConfiguration("/management/**", configuration);
            source.registerCorsConfiguration("/v2/api-docs", configuration);
        }
        return new CorsFilter(source);
    }
}
