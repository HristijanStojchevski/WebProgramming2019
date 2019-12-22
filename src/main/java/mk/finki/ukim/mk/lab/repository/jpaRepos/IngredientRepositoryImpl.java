package mk.finki.ukim.mk.lab.repository.jpaRepos;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.vm.Page;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;

import java.util.Optional;

public class IngredientRepositoryImpl implements IngredientRepository {

    private final JpaIngredientRepository repository;

    public IngredientRepositoryImpl(JpaIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String name) {
        return Optional.empty();
    }

    @Override
    public void delete(String name) {

    }
}
