package mk.finki.ukim.mk.lab.repository.inMemoryRepos;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class inMemPizzaRepository implements PizzaRepository {

    @Override
    public List<Pizza> getAllPizzas() {
        return DataHolder.pizzas;
    }

    @Override
    public Pizza save(Pizza pizza) {
        return null;
    }

    @Override
    public Pizza edit(String name, String desc, List<Ingredient> ingredients, boolean veggie) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public Optional<Pizza> get(String name) {
        return Optional.empty();
    }

    @Override
    public boolean exists(String name) {
        return false;
    }
}
