package foodz.web.service;

import foodz.entity.Recipe.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
    Recipe getRecipe(long id);

    void update(Recipe recipe);

    void delete(long id);

    void save(Recipe recipe);
}
