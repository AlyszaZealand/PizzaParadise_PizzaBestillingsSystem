package feedback.pizzaparadise_pizzabestillingssystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleBadRequestException(IllegalArgumentException ex, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errors", ex.getMessage());
        modelAndView.addObject("previousUrl", request.getHeader("Referer"));
        return "redirect:/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errors", ex.getMessage());
        modelAndView.addObject("previousUrl", request.getHeader("Referer"));
        return "redirect:/error";
    }

    @ExceptionHandler(ValidationException.class)
    public String handleValidationException(ValidationException ex, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errors", ex.getErrors());
        redirectAttributes.addFlashAttribute("previousUrl", request.getHeader("Referer"));
        return "redirect:/error";
    }

}
