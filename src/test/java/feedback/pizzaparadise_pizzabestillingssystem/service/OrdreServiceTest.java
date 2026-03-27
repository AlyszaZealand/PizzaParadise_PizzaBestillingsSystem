package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdreServiceTest {

    @Mock
    private OrdreRepository ordreRepository;

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private OrdreService ordreService;

    @Test
    void testFindPizzasOrderedByUser(){
        int testUserId = 1;

        List<Ordre> fakeOrders = new ArrayList<>();
        fakeOrders.add(new Ordre(101, 5, 65, LocalDateTime.now(), testUserId));
        fakeOrders.add(new Ordre(102, 7, 75, LocalDateTime.now(), testUserId));

        Pizza Hawaii = new Pizza(5, "Hawaii", "Ananas", 65, 1);
        Pizza Pepperoni = new Pizza(7, "Pepperoni", "Spicy", 75, 1);

        when(ordreRepository.findOrderByUser(testUserId)).thenReturn(fakeOrders);
        when(pizzaRepository.findById(5)).thenReturn(Optional.of(Hawaii));
        when(pizzaRepository.findById(7)).thenReturn(Optional.of(Pepperoni));

        List<Pizza> resultat =  ordreService.findPizzasOrderedByUser(testUserId);
        assertEquals(2, resultat.size());

        assertEquals("Hawaii", resultat.get(0).getName());
        assertEquals(5, resultat.get(0).getPizzaID());

        assertEquals("Pepperoni", resultat.get(1).getName());
        assertEquals(7, resultat.get(1).getPizzaID());
    }



}