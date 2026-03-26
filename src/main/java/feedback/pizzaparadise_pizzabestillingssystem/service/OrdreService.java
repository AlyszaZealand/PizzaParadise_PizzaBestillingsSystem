package feedback.pizzaparadise_pizzabestillingssystem.service;

import feedback.pizzaparadise_pizzabestillingssystem.model.Ordre;
import feedback.pizzaparadise_pizzabestillingssystem.model.User;
import feedback.pizzaparadise_pizzabestillingssystem.model.repositories.OrdreRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdreService {

    private final OrdreRepository ordreRepository;

    public OrdreService(OrdreRepository ordreRepository) {
        this.ordreRepository = ordreRepository;
    }

    public void findOrderByUser(User user){
        ordreRepository.findOrderByUser(user);
    }

    public void getDate(Ordre ordre) {
        ordre.getDate();
    }

    public void findAllOrdreById(Ordre ordre) {
        ordreRepository.findById(ordre);
    }

    public void saveOrdre(Ordre ordre) {
        ordreRepository.save(ordre);
    }

    public void deleteOrdre(Ordre ordre) {
        ordreRepository.delete(ordre);
    }




}
