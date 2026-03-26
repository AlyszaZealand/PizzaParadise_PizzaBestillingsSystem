package feedback.pizzaparadise_pizzabestillingssystem.repository;

import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// STEP 1
@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Navn, email, adresse, bonuspoint
    @Override
    public List<User> findAllUsers() {
        String sql = """
                SELECT id as userID,
                name,
                email,
                address,
                bonuspoints
                FROM `user`
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                        rs.getInt("UserID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("bonuspoints")
                ));
    }


    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT id as userID, name, email, address, bonuspoints FROM `user` where id = ?";
        List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                        rs.getInt("UserID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("bonuspoints")
                ), id);

        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO `user` (name, email, address, bonusPoint) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getBonuspoints()
        );
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE `user` SET name = ?, email = ?, address = ?, bonusPoint = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getBonuspoints(),
                user.getUserID()
        );
    }


    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM `user` WHERE email = ?";
        List <User> results = jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("address"),
                rs.getInt("bonuspoints")
        ), email);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}
