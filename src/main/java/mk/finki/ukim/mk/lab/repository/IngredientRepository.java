package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IngredientRepository {
    Ingredient save(Ingredient ingredient);

    Ingredient edit(String name, boolean spicy, float ammount, boolean veggie);
    //ako ne funkcionira smeni so tvoja implementacija na paginacija
    Page<Ingredient> getAllIngredients(int page, int size);

    Optional<Ingredient> findById(String name);

    void delete(String name);

    boolean existsById(String name);
}
