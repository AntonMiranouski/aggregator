package by.it.app;

import by.it.app.config.AppConfiguration;
import by.it.app.model.User;
import by.it.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    public UserRepo userRepo;

    public static void main(String[] args){

        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Main main = applicationContext.getBean("main", Main.class);

        User user1 = new User();
        user1.setUsername("user1");
        user1.setEmail("user1@mail.com");
        user1.setPassword("123");
        main.userRepo.save(user1);
    }

}
