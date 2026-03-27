package feedback.pizzaparadise_pizzabestillingssystem.service.ServiceValidation;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceValidation {

    private final UserRepository  userRepository;

    public UserServiceValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateEmail(String email, List<String> errors){
        if(email == null || email.trim().isEmpty()){
            errors.add("Email feltet må ikke være tomt");
        } else if (!email.contains("@")) {
            errors.add("Email skal indeholde '@' ");
        } else {
            Optional<User> existingUser = userRepository.findByEmail(email);
            if (existingUser.isPresent()) {
                errors.add("Der er allerede en bruger med den email");
            }
        }
    }

    public void validateUsername(String name, List<String> errors){
        if(name == null || name.trim().isEmpty()){
            errors.add("Navne feltet må ikke være tomt");
        }
    }

    public void validateAddress(String address, List<String> errors){
        if(address == null || address.trim().isEmpty()){
            errors.add("Adresse feltet må ikke være tomt");
        }
    }

}
