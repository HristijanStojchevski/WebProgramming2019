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

    @PostConstruct
    public void init(){
        pizzas.add(new Pizza("Margarita","tomato sauce, mozzarella"));
        pizzas.add(new Pizza("Carbonara ","fresh cream, mozzarella, bacon"));
        pizzas.add(new Pizza("Capricciosa","One of the best pizzas"));
        pizzas.add(new Pizza("Vezuvio","Named after a famous volcano"));
        pizzas.add(new Pizza("Calzone","Folded pizza"));
        pizzas.add(new Pizza("Quattro Formaggi","4 kinds of cheese"));
        pizzas.add(new Pizza("Quttro Stagioni","4 kinds of season topics"));
        pizzas.add(new Pizza("Hawaii","Pizza with pineapple"));
        pizzas.add(new Pizza("Vegetariana","Not only for vegetarians"));
        pizzas.add(new Pizza("Parmigiana","Famous italian pizza with mozzarela and parmiggiano-regiano"));

    }
}
