package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    List<Pizza> listPizzas(int totalIngredients);

    Pizza createPizza(String name,String desc,List<Ingredient> ingredients,boolean veggie);

    Pizza editPizza(String name,String desc, List<Ingredient> ingredients,boolean veggie);

    void deletePizza(String name);

    Pizza getPizza(String name);

    boolean existsById(String name);
}
