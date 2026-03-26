package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreService {

    private final OrdreRepository ordreRepository;
    private final UserRepository userRepository;
    private final PizzaRepository pizzaRepository;
    private final UserService userService;
    private final PizzaService pizzaService;

    public OrdreService(OrdreRepository ordreRepository, UserRepository userRepository, PizzaRepository pizzaRepository, UserService userService, PizzaService pizzaService) {
        this.ordreRepository = ordreRepository;
        this.userRepository = userRepository;
        this.pizzaRepository = pizzaRepository;
        this.userService = userService;
        this.pizzaService = pizzaService;
    }

   /* public void findOrderByUser(User user){
        Optional<User> currentUser = userService.findById(user.getUserID());
        ordreRepository.findOrderByUser(currentUser.get().getUserID());
        List<Pizza> currentOrders =
    }*/

    public void getDate(Ordre ordre) {
        ordre.getDate();
    }

    public void findAllOrdreById(Ordre ordre) {
        ordreRepository.findById(ordre.getOrdreID());
    }

    public void saveOrdre(Ordre ordre) {
        ordreRepository.save(ordre);
    }

    public void deleteOrdre(Ordre ordre) {
        ordreRepository.delete(ordre.getOrdreID());
    }


}
