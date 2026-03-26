package feedback.pizzaparadise_pizzabestillingssystem.repository;

import org.springframework.dao.DataAccessException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConfig {
//    public DB() {
//        Properties props = new Properties();
//
//        try (InputStream is = getClass().getResourceAsStream("/db.properties")) {
//            if (is == null) {
//                throw new DataAccessException("Could not find db.properties in resources");
//            }
//            props.load(is);
//        } catch (Exception e) {
//            throw new DataAccessException("Could not read db.properties", e);
//        }
//
//        this.url = props.getProperty("db.url");
//        this.user = props.getProperty("db.user");
//        this.password = props.getProperty("db.password");
//
//                spring.datasource
//    }
//
//    public Connection getConnection() {
//        try {
//            return DriverManager.getConnection(url, user, password);
//        } catch (Exception e) {
//            throw new DataAccessException("Could not establish database connection", e);
//        }
//    }


}
