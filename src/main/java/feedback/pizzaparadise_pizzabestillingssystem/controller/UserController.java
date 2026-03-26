package feedback.pizzaparadise_pizzabestillingssystem.controller;


import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

        UserService userService;

        private UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/register")
        public String registerForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/register/success")
        public String handleRegisterForm(@ModelAttribute("user") User user, Model model) {
            userService.createUser(user);
            model.addAttribute("user", user.getName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("address", user.getAddress());
            return "success";
        }

        @GetMapping("/login")
        public String loginForm(Model model) {
            model.addAttribute("user", new User());
            return "login";
        }

        @PostMapping("/login")
        public String handleLoginForm(@ModelAttribute("user") String email, Model model) {
            userService.userLogin(email);
            return "OrderPizza";
        }
}
