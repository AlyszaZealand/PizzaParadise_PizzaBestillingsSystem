package feedback.pizzaparadise_pizzabestillingssystem.repository;

import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// STEP 2
@Repository
public class JdbcPizzaRepository implements PizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //skal lave join så topping vises
    public List<Pizza> findAll() {
        String sql = """
                SELECT id, name, description, price, toppingID
                FROM pizza
                ORDER BY title
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("toppingId")
                )
        );
    }


    public Optional<Pizza> findById(int id) {
        String sql = """
                SELECT id, name, description, price, toppingId
                from pizza
                WHERE id = ?
                """;

        List<Pizza> pizza = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("toppingId")
                ), id
        );

        if (pizza.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(pizza.get(0));
    }


    @Override
    public void save(Pizza pizza) {
        String sql = "INSERT INTO pizza (name, description, price, toppingId) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                pizza.getName(),
                pizza.getDescription(),
                pizza.getPrice(),
                pizza.getToppingID()
        );
    }

    public void deleteById(int id){
        String sql = "DELETE FROM pizza WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
