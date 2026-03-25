package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;

import java.util.List;
import java.util.Optional;

public interface OrdreRepository {

    void save(Ordre ordre);

    Optional<Ordre> findById(int id);

    List<Ordre> findOrderByUser(int userId);

    void delete(int id);


}
