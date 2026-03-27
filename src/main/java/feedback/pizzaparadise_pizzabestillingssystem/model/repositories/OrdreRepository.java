package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;

import java.util.List;
import java.util.Optional;

public interface OrdreRepository {

    void save(Ordre ordre);

    Optional<Ordre> findById(int orderId);

    List<Ordre> findOrderByUser(int userid);

    void delete(int id);


}
