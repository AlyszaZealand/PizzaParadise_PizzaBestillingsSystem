package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> createUser(User user) {
       List<String> errors = new ArrayList<>();
       validateUsername(user.getName(), errors);
       validateEmail(user.getEmail(), errors);
       validateAddress(user.getAddress(), errors);
       if (errors.isEmpty()){
           userRepository.save(user);
       }
       return errors;
    }

    public void updateUser(User user) {
        List<String> errors = new ArrayList<>();
        validateUsername(user.getName(), errors);
        if(errors.isEmpty()){
            userRepository.update(user);
        }
    }

    public Optional<User> userLogin(String email){
        return userRepository.findByEmail(email);
    }


    public List<User> findAllUsers(){
       return userRepository.findAllUsers();
    }

    public Optional<User> getFindByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    private int getBonuspoints(User user){
       return user.getBonuspoints();
    }



    private void validateEmail(String email, List<String> errors){
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

    private void validateUsername(String name, List<String> errors){
        if(name == null || name.trim().isEmpty()){
            errors.add("Navne feltet må ikke være tomt");
        }
    }

    private void validateAddress(String address, List<String> errors){
        if(address == null || address.trim().isEmpty()){
            errors.add("Adresse feltet må ikke være tomt");
        }
    }
}
