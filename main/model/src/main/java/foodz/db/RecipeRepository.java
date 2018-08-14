package foodz.db;

import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Get all vegan recipes
    @Query
    List<Recipe> findByVeganTrue();

    // Get all NON vegan recipes
    @Query
    List<Recipe> findByVeganFalse();

    // Get all vegetarian recipes
    @Query
    List<Recipe> findByVegetarianTrue();

    // Get all non Vegetarian recipes
    @Query
    List<Recipe> findByVegetarianFalse();

    // Get all containing gluten recipes
    @Query
    List<Recipe> findByGlutenTrue();

    // Get all glutose free recipes
    @Query
    List<Recipe> findByGlutenFalse();

    // Get all containing lactose recipes
    @Query
    List<Recipe> findByLactoseTrue();

    // Get all Lactose Free recipes
    @Query
    List<Recipe> findByLactoseFalse();

    // Get all nuts containg recipes
    @Query
    List<Recipe> findByNutsTrue();

    // Get all nut free recipes
    @Query
    List<Recipe> findByNutsFalse();

}
