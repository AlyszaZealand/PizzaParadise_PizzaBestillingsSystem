package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;


import java.util.List;
import java.util.Optional;

public interface PizzaRepository {

    List<Pizza> findAll();

    Optional<Pizza> findById(int id);

    void save (Pizza pizza);

    void deleteById(int id);
}
