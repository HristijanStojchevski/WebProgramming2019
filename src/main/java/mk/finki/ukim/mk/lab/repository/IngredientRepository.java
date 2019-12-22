package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.vm.Page;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    Ingredient save(Ingredient ingredient);

    Page<Ingredient> getAllIngredients(int page,int size);

    Optional<Ingredient> findById(String name);

    void delete(String name);
}
