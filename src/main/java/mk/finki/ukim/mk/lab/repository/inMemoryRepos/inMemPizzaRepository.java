package mk.finki.ukim.mk.lab.repository.inMemoryRepos;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class inMemPizzaRepository implements PizzaRepository {

    Pizza margarita = new Pizza("Margarita","Famous pizza with little to non ingredients");
    Pizza napolitana = new Pizza("Neapolitana","Neapoles pride");

    Pizza capricciosa = new Pizza("Capricciosa","One of the best pizzas");

    Pizza vezuvio= new Pizza("Vezuvio","Named after a famous volcano");

    Pizza calzone = new Pizza("Calzone","Folded pizza");

    Pizza quattroForm = new Pizza("Quattro Formaggi","4 kinds of cheese");

    Pizza quatrroStag = new Pizza("Quttro Stagioni","4 kinds of season topics");

    Pizza hawaii = new Pizza("Hawaii","Pizza with pineapple");

    Pizza vege = new Pizza("Vegetariana","Not only for vegetarians");

    Pizza parmiggiana = new Pizza("Parmigiana","Famous italian pizza with mozzarela and parmiggiano-regiano");
    public List<Pizza> listPizzas = Arrays.asList(margarita, napolitana, capricciosa, vezuvio, calzone,quatrroStag,quattroForm,hawaii,vege);

    //public List<Pizza> listPizza = new ArrayList<>(10);
    @Override
    public List<Pizza> getAllPizzas() {
        return listPizzas;
    }
}
