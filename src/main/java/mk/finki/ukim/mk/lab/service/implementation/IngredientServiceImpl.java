package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidIngredientException;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Ingredient createIngredient(String name, boolean spiccy, float ammount, boolean veggie) {
        Ingredient newIngredient = new Ingredient(name,spiccy,ammount,veggie);
        return this.ingredientRepository.save(newIngredient);
    }

    @Override
    public Ingredient editIngredient(String name, boolean spiccy, float ammount, boolean veggie) {
        return this.ingredientRepository.edit(name,spiccy,ammount,veggie);
    }

    @Override
    public void deleteIngredient(String name) {
        this.ingredientRepository.delete(name);
    }

    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        return this.ingredientRepository.getAllIngredients(page,size);
    }

    @Override
    public Ingredient getIngredient(String name) {
        return this.ingredientRepository.findById(name).orElseThrow(InvalidIngredientException::new);
    }

    @Override
    public boolean existsById(String name) {
        return this.ingredientRepository.existsById(name);
    }
}
