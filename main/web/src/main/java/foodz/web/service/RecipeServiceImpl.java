package foodz.web.service;

import foodz.db.RecipeRepository;
import foodz.entity.Recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("foodz.db")
public class RecipeServiceImpl implements RecipeService {


    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipe(long id) {
        return recipeRepository.getOne(id);
    }

    public void update(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void delete(long id) {
        recipeRepository.delete(getRecipe(id));
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
