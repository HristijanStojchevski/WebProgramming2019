package mk.finki.ukim.mk.lab.repository.jpaRepos;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIngredientRepository extends JpaRepository<Ingredient,String> {
}
