package az.edu.ada.wm2.springbootsecurityframeworkdemo.init;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.entity.User;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbUsersBootstrapper {

//    @Autowired
//    UserRepository userRepo;

    @Bean
    public ApplicationRunner init(UserRepository userRepo, PasswordEncoder encoder) {
        return (args) -> {
            User adminUser = new User("admin",
                    encoder.encode("admin"), "admin_user@ada.edu.az");
            userRepo.save(adminUser.addRole("ROLE_ADMIN"));

            userRepo.save(
                    new User("nsadili",
                            encoder.encode("12345"), "nsadili@ada.edu.az"));
        };
    }

}
