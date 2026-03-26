package feedback.pizzaparadise_pizzabestillingssystem.repository;

import feedback.pizzaparadise_pizzabestillingssystem.model.Topping;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.ToppingRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// STEP 3
@Repository
public class JdbcToppingRepository implements ToppingRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcToppingRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Topping> findAll(){
        String sql = "SELECT * FROM topping ORDER BY name ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Topping(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        ));
    }

    @Override
    public Optional<Topping> findById(int id) {
        String sql = "SELECT * FROM topping WHERE id = ?";
        List<Topping> results = jdbcTemplate.query(sql, (rs, rowNum) -> new Topping(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        ), id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public void save(Topping topping){
        String sql = "INSERT INTO topping (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, topping.getName(), topping.getPrice());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM topping WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
