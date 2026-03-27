package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import feedback.pizzaparadise_pizzabestillingssystem.service.ServiceValidation.UserServiceValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserServiceValidation userServiceValidation;

    public  UserService(UserRepository userRepository, UserServiceValidation userServiceValidation) {
        this.userRepository = userRepository;
        this.userServiceValidation = userServiceValidation;
    }

    public List<String> createUser(User user) {
       List<String> errors = new ArrayList<>();
       userServiceValidation.validateUsername(user.getName(), errors);
       userServiceValidation.validateEmail(user.getEmail(), errors);
       userServiceValidation.validateAddress(user.getAddress(), errors);
       if (errors.isEmpty()){
           userRepository.save(user);
       }
       return errors;
    }

    public void updateUser(User user) {
        List<String> errors = new ArrayList<>();
        userServiceValidation.validateUsername(user.getName(), errors);
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
       return user.getBonusPoint();
    }

}
