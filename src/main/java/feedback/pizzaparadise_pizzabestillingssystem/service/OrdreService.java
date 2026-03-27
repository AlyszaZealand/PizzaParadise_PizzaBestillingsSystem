package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.Topping;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreService {

    private final OrdreRepository ordreRepository;
    private final ToppingRepository toppingRepository;
    private final PizzaRepository pizzaRepository;


    public OrdreService(OrdreRepository ordreRepository, PizzaRepository pizzaRepository, ToppingRepository  toppingRepository) {
        this.ordreRepository = ordreRepository;
        this.pizzaRepository = pizzaRepository;
        this.toppingRepository = toppingRepository;
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

    public double calculateTotalPrice(int pizzaId, List<Integer> toppingIds) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElse(null);
        if (pizza == null) return 0.0;

        double total = pizza.getPrice();

        // Add price of each chosen topping
        for (int toppingId : toppingIds) {
            Topping topping = toppingRepository.findById(toppingId).orElse(null);
            if (topping != null) {
                total += topping.getPrice();
            }
        }
        return total;
    }

}
