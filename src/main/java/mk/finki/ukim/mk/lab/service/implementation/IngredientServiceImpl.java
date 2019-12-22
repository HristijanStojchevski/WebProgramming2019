package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.jpaRepos.JpaIngredientRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImpl implements IngredientService {
    private final JpaIngredientRepository jpaIngredientRepository;

    public IngredientServiceImpl(JpaIngredientRepository jpaIngredientRepository) {
        this.jpaIngredientRepository = jpaIngredientRepository;
    }

    @Override
    public Ingredient createIngredient(String name, boolean spiccy, float ammount, boolean veggie) {
        return null;
    }

    @Override
    public Ingredient editIngredient(String name, boolean spiccy, float ammount, boolean veggie) {
        return null;
    }

    @Override
    public void deleteIngredient(String name) {

    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public Ingredient getIngredient(String name) {
        return null;
    }
}
