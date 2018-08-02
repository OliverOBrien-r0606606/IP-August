package foodz.db;

import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {



}
