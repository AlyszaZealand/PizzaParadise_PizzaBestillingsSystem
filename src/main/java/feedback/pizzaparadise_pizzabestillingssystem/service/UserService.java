package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final OrdreRepository ordreRepository;
    private List<String> errors;

    public  UserService(UserRepository userRepository, List<String> errors, OrdreRepository ordreRepository) {
        this.userRepository = userRepository;
        this.errors = errors;
        this.ordreRepository = ordreRepository;
    }

    public void createUser(User user){
        validateUsername(user);
        validateUsernameEmpty(user);
        validateUserEmail(user);
        userRepository.save(user);
    }

    public void editUser(User user){
        validateUsername(user);
        userRepository.update(user);
    }

    public List<User> findAllUsers(){
       return userRepository.findAllUsers();
    }

    public void getFindByEmail(User user){
        userRepository.findByEmail(user);
    }

    private void getFindById(User user){
        userRepository.findById(user);
    }

    private void getBonuspoints(User user){
        user.getBonuspoints();
    }

//    public void addBonusPoint(User user){
//        if(user.getUserID() == 2)
//    }

    private List<String> validateUserEmailEmpty(User user){
        // Email må ikke være tom
        List<String> errors = new ArrayList<>();
        if(user.getEmail()==null){
            String errorMessage = "Email må ikke være tom";
            errors.add(errorMessage);
        }
        return errors;
    }

    private List<String> validateUserEmail(User user) {
        // Email skal indeholde '@'
        if(!user.getEmail().contains("@")){
            String errorMessage = "Emal skal indholde '@'";
            errors.add(errorMessage);
        }
        return errors;
    }

    private List<String> validateUsername(User user) {
        // Brugernavn må ikke indeholde mellemrum
        if(user.getName().contains(" ")){
            String errorMessage = "Brugernavn må ikke indholde 'mellemrum'";
            errors.add(errorMessage);
        }
        return errors;
    }

    private List<String> validateUsernameEmpty(User user){
        // Email må ikke være tom
        List<String> errors = new ArrayList<>();
        if(user.getName()==null){
            String errorMessage = "Brugernavn må ikke være tom";
            errors.add(errorMessage);
        }
        return errors;
    }

    private List<String> validateUserAddress(User user){
        // Adressen må ikke være tom
        if(user.getAddress()==null){
            String errorMessage = "Adressen må ikke være tom";
            errors.add(errorMessage);
        }
        return errors;
    }

    private List<String> validateRegisteredUserList(User user){
        // Bruger eksistere ikke i listen
        if(!userRepository.findById(user).equals(user.getUserID())){
            String errorMessage = "Brugeren eksistere ikke";
            errors.add(errorMessage);
        }
        return errors;
    }







}
