package feedback.pizzaparadise_pizzabestillingssystem.model.repositories;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    void update(User user);

    Optional<User> findById(User user);

    Optional<User> findByEmail(User user);

    List<User> findAllUsers();

}
