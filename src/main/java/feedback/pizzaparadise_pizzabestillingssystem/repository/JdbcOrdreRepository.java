package feedback.pizzaparadise_pizzabestillingssystem.repository;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// STEP 4
@Repository
public class JdbcOrdreRepository implements OrdreRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOrdreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //skal nok noget join for at vise pizza
    public List<Ordre> findOrderByUser(User user) {
        String sql = """
                SELECT o.id AS ordre_id, o.date, o.totalPrice,
                       p.id AS pizza_id, p.name AS pizza_name, p.price AS pizza_price
                FROM ordre o
                JOIN pizza p ON o.pizzaid = p.id
                where o.userid = ?;
                """;

        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Ordre(
                        rs.getInt("id"),
                        rs.getInt("pizzaid"),
                        rs.getDouble("totalPrice"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getInt("userid")
                ), user.getUserID()
        );
    }




    public Optional<Ordre> findById(Ordre ordreId) {
        String sql = """
            SELECT o.id, o.date, o.totalPrice, o.pizzaid, o.userid
            FROM ordre o
            WHERE o.id = ?
            """;
        //Måske throw i metode signatur.
        try {
            Ordre ordre = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Ordre(
                            rs.getInt("id"),
                            rs.getInt("pizzaid"),
                            rs.getDouble("totalPrice"),
                            rs.getTimestamp("date").toLocalDateTime(),
                            rs.getInt("userid")
                    ), ordreId.getOrdreID());
            return Optional.ofNullable(ordre);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void save(Ordre ordre){
        String sql = "insert into ordre (date,totalprice,pizzaid,userid) values (?,?,?,?)";
        jdbcTemplate.update(sql,
                ordre.getDate(),
                ordre.getTotalPrice(),
                ordre.getPizzaID(),
                ordre.getUserID()
                );
    }

    public void delete(Ordre ordre){
        String sql = "delete from ordre where id = ?";

        jdbcTemplate.update(sql,ordre.getOrdreID());

    }

}
