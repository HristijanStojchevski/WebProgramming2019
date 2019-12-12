package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor //Prashaj zoshto notacijata ne funkcionira
@NoArgsConstructor
@Data
public class Pizza {

    private String name;
    private String description;

}
