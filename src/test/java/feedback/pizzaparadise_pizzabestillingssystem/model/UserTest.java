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

        // Test Addresse
        assertEquals("Bobbystreet69", user.getAddress());

        // Test Bonuspoints
        assertEquals(1, user.getBonuspoints());
    }

    @Test
    void testConstructorWithoutID() {
    }



}