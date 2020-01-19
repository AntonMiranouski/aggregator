package by.it.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The main App configuration.
 */
@Configuration
@ComponentScan(basePackages = "by.it")
@Import({DatabaseConfiguration.class, WebConfiguration.class, SecurityConfiguration.class, SwaggerConfiguration.class})
public class AppConfiguration {
}
