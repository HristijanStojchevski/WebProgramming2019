package mk.finki.ukim.mk.lab.model;

import ch.qos.logback.classic.db.names.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//@Table(name = "INGREDIENTS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    @Id
    private String name;

    private boolean spicy;

    private float ammount;
    //@Column(name = "Veggetarian")
    private boolean veggie;
    //In case I need this in order the relation to work...
    //@ManyToMany(fetch = FetchType.EAGER)
    //private List<Pizza> pizzas;

}
