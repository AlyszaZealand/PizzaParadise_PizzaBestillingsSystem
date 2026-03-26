package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.Topping;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final ToppingRepository toppingRepository;
    private List<String> errors;

    public PizzaService(PizzaRepository pizzaRepository, List<String> errors, ToppingRepository toppingRepository) {
        this.pizzaRepository = pizzaRepository;
        this.toppingRepository = toppingRepository;
        this.errors = errors;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(int id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public void createPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public void deletePizza(int id) {
        pizzaRepository.deleteById(id);
    }

    // From topping repo
    public void findAllToppings(Topping topping) {
        toppingRepository.findAll();
    }
    public void findToppingById(int id) {
        toppingRepository.findById(id);
    }








}
