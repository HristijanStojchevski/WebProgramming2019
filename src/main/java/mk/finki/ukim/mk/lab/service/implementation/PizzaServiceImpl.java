package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidPizzaException;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidPizzaExceptionNoMsg;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas(int totalIngredients) {
        List<Pizza> pizzas = this.pizzaRepository.getAllPizzas();
        return pizzas.stream().filter(pizza -> pizza.getIngredients().size()<=totalIngredients).collect(Collectors.toList());
    }

    @Override
    public Pizza createPizza(String name,String desc,List<Ingredient> ingredients,boolean veggie) {
        Pizza pizza = new Pizza(name,desc,ingredients,veggie);
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza editPizza(String name, String desc, List<Ingredient> ingredients, boolean veggie) {
        return this.pizzaRepository.edit(name,desc,ingredients,veggie);
    }

    @Override
    public void deletePizza(String name) {
        this.pizzaRepository.delete(name);
    }

    @Override
    public Pizza getPizza(String name) {
        return this.pizzaRepository.get(name).orElseThrow(InvalidPizzaExceptionNoMsg::new);
    }

    @Override
    public boolean existsById(String name) {
        return this.pizzaRepository.exists(name);
    }

}
