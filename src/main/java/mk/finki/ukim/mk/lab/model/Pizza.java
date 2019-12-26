package mk.finki.ukim.mk.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@AllArgsConstructor //Prashaj zoshto notacijata ne funkcionira
@NoArgsConstructor
@Data
//@Table(name = "PIZZAS")
public class Pizza {
    /*@Id
    private float id;*/
    @Id
    private String name;

    private String description;
    //@JsonIgnore
    @ManyToMany//(mappedBy = "pizzas")
    //@NotFound(action = NotFoundAction.IGNORE)
    private List<Ingredient> ingredients;

    private boolean veggie;
}
