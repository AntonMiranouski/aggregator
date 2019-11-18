package by.it.app;

import by.it.app.config.AppConfiguration;
import by.it.app.repository.CategoryRepo;
import by.it.app.repository.UserRepo;
import by.it.app.repository.WebsiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public WebsiteRepo websiteRepo;

    @Autowired
    public CategoryRepo categoryRepo;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Main main = applicationContext.getBean("main", Main.class);

    }

}
