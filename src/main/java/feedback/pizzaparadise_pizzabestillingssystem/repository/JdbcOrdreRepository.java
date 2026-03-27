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
    public List<Ordre> findOrderByUser(int userId) {
        String sql = "SELECT id, date, totalprice, pizzaid, userid FROM ORDRE WHERE userid = ?";
        return jdbcTemplate.query(sql,(rs,rowNum)-> new Ordre(
                        rs.getInt("id"),
                        rs.getInt("pizzaid"),
                        rs.getDouble("totalPrice"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getInt("userid")
                ), userId);
    }


    public Optional<Ordre> findById(int id) {
        String sql = " SELECT id, date, totalPrice, pizzaid, userid FROM ordre WHERE id = ?";

        //Måske throw i metode signatur.
        try {
            Ordre ordre = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Ordre(
                            rs.getInt("id"),
                            rs.getInt("pizzaid"),
                            rs.getDouble("totalPrice"),
                            rs.getTimestamp("date").toLocalDateTime(),
                            rs.getInt("userid")
                    ), id);
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

    //måske int id.
    public void delete(int id){
        String sql = "DELETE FROM ordre WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

}
