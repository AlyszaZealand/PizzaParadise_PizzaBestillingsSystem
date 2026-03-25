package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.Topping;

import java.util.List;
import java.util.Optional;

public interface ToppingRepository {

    List<Topping> findAll();

    Optional<Topping> findById(int id);

    void save (Topping topping);

    void deleteById(int id);

}
