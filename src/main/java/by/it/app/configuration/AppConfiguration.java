package by.it.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.it")
@Import({DatabaseConfiguration.class, WebConfiguration.class, SecurityConfiguration.class})
public class AppConfiguration {
}
