package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    Ingredient createIngredient(String name,boolean spiccy,float ammount,boolean veggie);

    Ingredient editIngredient(String name, boolean spiccy, float ammount, boolean veggie);

    void deleteIngredient(String name);

    Page<Ingredient> getAllIngredients(int page, int size);

    Ingredient getIngredient(String name);

    boolean existsById(String name);
}
