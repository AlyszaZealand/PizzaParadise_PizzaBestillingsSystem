package feedback.pizzaparadise_pizzabestillingssystem.controller;


import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UserController {

        UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/register")
        public String registerForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/register/success")
        public String handleRegisterForm(@ModelAttribute("user") User user, Model model) {
            List<String> errors = userService.createUser(user);

            if (!errors.isEmpty()) {
                model.addAttribute("errors", errors); // send errors back to the form
                model.addAttribute("user", user);     // keep the form filled in
                return "register";                    // go back to register page
            }

            return "success";
        }

        @GetMapping("/login")
        public String loginForm(Model model) {
            model.addAttribute("user", new User());
            return "login";
        }

        @PostMapping("/login/pizzapage")
        public String handleLoginForm(@ModelAttribute("user") User user,
                                  HttpSession session, Model model) {
            Optional<User> foundUser = userService.userLogin(user.getEmail());

            if(foundUser.isEmpty()){
                model.addAttribute("error", "Ingen bruger fundet med den email");
                return "login";
            }
            session.setAttribute("user", foundUser.get());
            return "redirect:/pizzapage";
        }




}
