package mk.finki.ukim.mk.lab.repository.jpaRepos;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class PizzaRepositoryImpl implements PizzaRepository {

    private final JpaPizzaRepository repository;

    public PizzaRepositoryImpl(JpaPizzaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return repository.findAll();
    }

    @Override
    public Pizza save(Pizza pizza) {
        return repository.save(pizza);
    }

    @Override
    public Pizza edit(String name, String desc, List<Ingredient> ingredients,boolean veggie) {
        Pizza updated = new Pizza(name,desc,ingredients,veggie);
        repository.deleteById(name);
        return repository.save(updated);
    }

    @Override
    public void delete(String name) {
        repository.deleteById(name);
    }

    @Override
    public Optional<Pizza> get(String name) {
        return repository.findById(name);
    }

    @Override
    public boolean exists(String name) {
        return repository.existsById(name);
    }


}
