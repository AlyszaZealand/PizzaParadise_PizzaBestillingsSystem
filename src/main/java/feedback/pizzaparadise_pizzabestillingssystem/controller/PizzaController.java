package feedback.pizzaparadise_pizzabestillingssystem.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaController {

    @GetMapping("/pizzapage")
    public String pizzapage(Model model) {
        return "pizzapage";
    }

    @PostMapping("/pizzapage/myOrders")
    public String pizzapageMyOrders(Model model) {
        return "redirect:/myOrders";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:";
    }


}
