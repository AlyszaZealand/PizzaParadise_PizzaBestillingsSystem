package feedback.pizzaparadise_pizzabestillingssystem.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorWithID() {
        User user = new User
                (1,
                "Bob",
                "Bob@gmail.com",
                "Bobbystreet69",
                1);

        // Test ID
        assertEquals(1, user.getUserID());

        // Test Navn
        assertEquals("Bob", user.getName());

        // Test Email
        assertEquals("Bob@gmail.com", user.getEmail());

        // Test Adresse
        assertEquals("Bobbystreet69", user.getAddress());

        // Test Bonuspoints
        assertEquals(1, user.getBonusPoint());
    }

    @Test
    void testConstructorWithoutID() {
        User user = new User("Keld",
                "Keld@gmail.com",
                "Keldstreet420",
                2);

        // Test ID = null
        assertEquals(0, user.getUserID());

        // Test Navn
        assertEquals("Keld", user.getName());

        // Test Adresse
        assertEquals("Keld@gmail.com", user.getEmail());

        // Test Email
        assertEquals("Keldstreet420", user.getAddress());

        // Test Bonuspoints
        assertEquals(2, user.getBonusPoint());
    }

    @Test
    void testEmptyConstructor() {
        User user = new User();

        // Test ID = null
        assertEquals(0, user.getUserID());

        // Test Navn = Null ( kunne ikke "")
        assertEquals(null, user.getName());

        // Test Bonuspoints = null
        assertEquals(0, user.getBonusPoint());
    }

    @Test
    void testSetters() {
        User user = new User();

        // Set Navn
        user.setName("GIGACHAD");

        // Test Set Navn
        assertEquals("GIGACHAD", user.getName());

        // Set Bonuspoints
        user.setBonusPoint(10);

        // Test Set Bonuspoints
        assertEquals(10, user.getBonusPoint());
    }

}