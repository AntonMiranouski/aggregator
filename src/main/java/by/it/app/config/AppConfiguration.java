package by.it.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan("by.it.app")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"by.it.app.repository"})
public class AppConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.properties.hibernate.default_schema}")
    private String defaultSchema;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.jpa.show-sql}")
    private String showSql;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName(driverClassName);
        driverManager.setUrl(url);
        driverManager.setUsername(username);
        driverManager.setPassword(password);
        return driverManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
        managerFactory.setDataSource(dataSource());
        managerFactory.setPackagesToScan("by.it.app.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        managerFactory.setJpaVendorAdapter(vendorAdapter);
        managerFactory.setJpaProperties(additionalProperties());
        return managerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Properties additionalProperties(){
        Properties properties = new Properties();
        properties.getProperty(defaultSchema);
        properties.getProperty(ddlAuto);
        properties.getProperty(showSql);
        return properties;
    }

}
