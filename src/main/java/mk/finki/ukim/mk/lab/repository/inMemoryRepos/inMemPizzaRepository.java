package mk.finki.ukim.mk.lab.repository.inMemoryRepos;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class inMemPizzaRepository implements PizzaRepository {

    @Override
    public List<Pizza> getAllPizzas() {
        return DataHolder.pizzas;
    }
}
