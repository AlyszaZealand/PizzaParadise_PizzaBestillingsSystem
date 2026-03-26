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

    // (navn, email, adresse, bonuspoint).
    @Override
    public List<User> findAllUsers() {
        String sql = """
                SELECT u.id AS userID,
                       u.name AS name,
                       u.email AS email,
                       u.address AS address,
                       u.bonuspoints AS bonuspoints
                FROM user u
                JOIN ordre o ON u.id = o.userID
                """;


        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                    rs.getInt("userID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getInt("bonuspoints")

                )
        );
    }

    @Override
    public Optional<User> findById(User user) {
        String sql = """
                SELECT u.id AS userID,
                       u.name AS name,
                       u.email AS email,
                       u.address AS address,
                       u.bonuspoints AS bonuspoints
                FROM user u
                JOIN ordre o ON u.id = o.userID
                where u.id = ?;
                """;

        List<User> list = jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                        rs.getInt("UserID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("bonuspoints")
                ), user.getUserID()
        );

        if (list.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(list.get(0));
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
    public Optional<User> findByEmail(User user) {
        String sql = "SELECT * FROM `user` WHERE email = ?";
        List <User> results = jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("address"),
                rs.getInt("bonuspoints")
        ), user.getEmail());
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}
