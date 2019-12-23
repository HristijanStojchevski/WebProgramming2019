package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    @Override
    public void createPizza(String name, String desc, List<Ingredient> ingredients, boolean veggie) {

    }

    @Override
    public void editPizza(String name, String desc, List<Ingredient> ingredients, boolean veggie) {

    }

    @Override
    public void deletePizza(String name) {

    }

    @Override
    public Pizza getPizza(String name) {
        return null;
    }
}
