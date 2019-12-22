package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static final List<Pizza> pizzas=new ArrayList<>();
    public static final List<Order> orders=new ArrayList<>();
    public static final List<Ingredient> ingredients = new ArrayList<>();
    @PostConstruct
    public void init(){
        pizzas.add(new Pizza("Margarita","tomato sauce, mozzarella",ingredients,true));
        pizzas.add(new Pizza("Carbonara ","fresh cream, mozzarella, bacon",ingredients,false));
        pizzas.add(new Pizza("Capricciosa","One of the best pizzas",ingredients,false));
        pizzas.add(new Pizza("Vezuvio","Named after a famous volcano",ingredients,false));
        pizzas.add(new Pizza("Calzone","Folded pizza",ingredients,false));
        pizzas.add(new Pizza("Quattro Formaggi","4 kinds of cheese",ingredients,false));
        pizzas.add(new Pizza("Quttro Stagioni","4 kinds of season topics",ingredients,false));
        pizzas.add(new Pizza("Hawaii","Pizza with pineapple",ingredients,false));
        pizzas.add(new Pizza("Vegetariana","Not only for vegetarians",ingredients,true));
        pizzas.add(new Pizza("Parmigiana","Famous italian pizza with mozzarela and parmiggiano-regiano",ingredients,false));

    }
}
