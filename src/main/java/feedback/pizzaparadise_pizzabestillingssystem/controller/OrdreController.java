package feedback.pizzaparadise_pizzabestillingssystem.controller;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.Pizza;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.service.OrdreService;
import feedback.pizzaparadise_pizzabestillingssystem.service.PizzaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class OrdreController {

    private final OrdreService ordreService;
    private final PizzaService  pizzaService;

    public OrdreController(OrdreService ordreService, PizzaService pizzaService) {
        this.ordreService = ordreService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/myOrders")
    public String myOrders(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");

        if(currentUser == null){
            return "redirect:/login";
        }

        model.addAttribute("orders",ordreService.findAllOrdreByUser(currentUser.getUserID()));
        model.addAttribute("pizzas", ordreService.findPizzasOrderedByUser(currentUser.getUserID()));
        return "myOrders";
    }

    @GetMapping("/bestil")
    public String orderPizza(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        model.addAttribute("ordre",new Ordre());
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        model.addAttribute("toppings",pizzaService.findAllToppings());
        return "bestil";
    }

    @PostMapping("/bestil/success")
    public String handleOrderPizza(HttpSession session, Model model,@RequestParam("pizzaID") int pizzaID) {
        User currentUser = (User) session.getAttribute("user");
        if(currentUser == null){
            return "redirect:/login";
        }
        Pizza valgtPizza = pizzaService.getPizzaById(pizzaID);
        Ordre nyOrdre = new Ordre();
        nyOrdre.setUserID(currentUser.getUserID());
        nyOrdre.setPizzaID(pizzaID);
        nyOrdre.setDate(LocalDateTime.now());
        ordreService.saveOrdre(nyOrdre);

        model.addAttribute("pizzaNavn",valgtPizza.getName());
        model.addAttribute("totalPris",valgtPizza.getPrice());
        return "bestiltsuccess";
    }

    @GetMapping("/bestil/success")
    public String bestiltSuccess() {
        return "bestiltsuccess";
    }
}
