package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaService pizzaService;

    @Test
    void testGetAllPizzas() {

        List<Pizza> fakeDbPizzas = new ArrayList<>();
        fakeDbPizzas.add(new Pizza(1, "Margherita", "Klassisk", 65, 1));
        fakeDbPizzas.add(new Pizza(2, "Hawaii", "Klassisk", 75, 1));

        when(pizzaRepository.findAll()).thenReturn(fakeDbPizzas);
        List<Pizza> resultat = pizzaService.getAllPizzas();

        assertEquals(2, resultat.size());

        assertEquals("Margherita", resultat.get(0).getName());
        assertEquals(65.0, resultat.get(0).getPrice());

        assertEquals("Pepperoni", resultat.get(1).getName());
        assertEquals(80.0, resultat.get(1).getPrice());
    }
}