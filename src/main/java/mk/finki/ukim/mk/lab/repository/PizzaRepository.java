package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;
import java.util.Optional;


public interface PizzaRepository {
    public List<Pizza> getAllPizzas();

    Pizza save(Pizza pizza);

    Pizza edit(String name, String desc, List<Ingredient> ingredients,boolean veggie);

    void delete(String name);

    Optional<Pizza> get(String name);

    boolean exists(String name);
}
