package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor //Prashaj zoshto notacijata ne funkcionira
@NoArgsConstructor
@Getter //Isto ne funkc
//@Data
public class Pizza {

    private String name;
    private String description;

    /*public Pizza(String name, String desc) {
        this.name = name;
        this.description = desc;
    }*/
    public boolean matches(String term){
        return this.name.contains(term) || this.description.contains(term);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
