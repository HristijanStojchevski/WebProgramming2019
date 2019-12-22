package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(String name,boolean spiccy,float ammount,boolean veggie);

    Ingredient editIngredient(String name, boolean spiccy, float ammount, boolean veggie);

    void deleteIngredient(String name);

    List<Ingredient> getAllIngredients();

    Ingredient getIngredient(String name);


}
