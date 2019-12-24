package mk.finki.ukim.mk.lab.repository.jpaRepos;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private final JpaIngredientRepository repository;

    public IngredientRepositoryImpl(JpaIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return this.repository.save(ingredient);
    }

    @Override
    public Ingredient edit(String name, boolean spicy, float ammount, boolean veggie) {
        Ingredient updatedIngredient = new Ingredient(name,spicy,ammount,veggie);
        this.repository.deleteById(name);
        return this.repository.save(updatedIngredient);
    }
    //Ako ne implementiraj so svoi strani
    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        if(size>10)size=10;
        return this.repository.findAll(PageRequest.of(page,size,Sort.by("name"))); //default Direction.ASC
    }

    @Override
    public Optional<Ingredient> findById(String name) {
        return this.repository.findById(name);
    }

    @Override
    public void delete(String name) {
        this.repository.deleteById(name);
    }

    @Override
    public boolean existsById(String name) {
        return this.repository.existsById(name);
    }
}
