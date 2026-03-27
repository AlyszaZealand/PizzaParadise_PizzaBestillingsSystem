package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import feedback.pizzaparadise_pizzabestillingssystem.service.ServiceValidation.OrdreServiceValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreService {

    private final OrdreRepository ordreRepository;

    private final PizzaRepository pizzaRepository;


    public OrdreService(OrdreRepository ordreRepository, PizzaRepository pizzaRepository) {
        this.ordreRepository = ordreRepository;
        this.pizzaRepository = pizzaRepository;

    }

    public List<Pizza> findPizzasOrderedByUser(int userId) {
        List<Ordre> brugerensOrdrer = ordreRepository.findOrderByUser(userId);

        List<Pizza> bestiltePizzaer = new ArrayList<>();

        for (Ordre ordre : brugerensOrdrer) {
            Optional<Pizza> fundetPizza = pizzaRepository.findById(ordre.getPizzaID());
            if (fundetPizza.isPresent()) {
                bestiltePizzaer.add(fundetPizza.get());
            }
        }
        return bestiltePizzaer;
    }


    public List<Ordre> findAllOrdreByUser(int userid) {
        return ordreRepository.findOrderByUser(userid);
    }

    public Optional<Ordre> findById(int ordreId) {
        return ordreRepository.findById(ordreId);
    }

    public void saveOrdre(Ordre ordre) {
        if (ordre.getUserID() <= 0 || ordre.getPizzaID() <= 0) {
            throw new IllegalArgumentException("Ordren skal være tilknyttet en gyldig bruger og pizza.");
        }
        ordreRepository.save(ordre);
    }

    public void deleteOrdre(int ordreId) {
        ordreRepository.delete(ordreId);
    }


}
