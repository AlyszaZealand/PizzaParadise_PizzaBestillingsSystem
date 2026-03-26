package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;

import java.util.List;
import java.util.Optional;

public interface OrdreRepository {

    void save(Ordre ordre);

    Optional<Ordre> findById(Ordre ordre);

    List<Ordre> findOrderByUser(User user);

    void delete(Ordre ordre);


}
