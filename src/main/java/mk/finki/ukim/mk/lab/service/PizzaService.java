package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;

public interface PizzaService {
    public List<Pizza> listPizzas();

    void createPizza(String name, String desc, List<Ingredient> ingredients,boolean veggie);

    void editPizza(String name,String desc, List<Ingredient> ingredients,boolean veggie);

    void deletePizza(String name);

    Pizza getPizza(String name);

}
