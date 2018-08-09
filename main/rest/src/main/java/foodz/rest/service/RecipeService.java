package foodz.rest.service;

import foodz.db.RecipeRepository;
import foodz.entity.Recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service

@ComponentScan("foodz.db")
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe getRecipe(Long id){
        return recipeRepository.getOne(id);
    }

}
