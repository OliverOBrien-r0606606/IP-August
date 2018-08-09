package foodz.rest.controller;

import foodz.db.RecipeRepository;
import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import foodz.rest.entity.Nutrition;
import foodz.rest.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("foodz.db")
public class NutritionController {

    @Autowired
    private RecipeService service;

    @RequestMapping("/request")
    public Nutrition getNutrition(){
        //List<Ingredient> ingredients = recipeRepository.getOne(id).getIngredients();
        //System.out.println(ingredients.toString());
        return new Nutrition("egg",0.1,0.1,0.20,0.65,0.66,0.11,0.55,0.4,0.336,0.264,0.12);
        //String name, double quantity, double calories, double total_fat, double saturated_fat, double cholesterol, double sodium, double total_carbohydrate, double dietary_fiber, double sugar, double protein, double potassium) {
        //
    }

    @RequestMapping("/recipeRequest")
    public ResponseEntity<List<Ingredient>> getRecipe(@RequestBody String id){
        Recipe recipe = service.getRecipe(Long.parseLong(id));
        /*
        System.out.println("###############[RECIPE]#################");
        System.out.println("NAME: "+recipe.getName());
        System.out.println("DESCRIPTION: "+recipe.getName());
        System.out.println("DIRECTIONS: "+recipe.getName());
        System.out.println("ID: "+recipe.getName());
        System.out.println("INGREDIENTS: ([ID]: amount unit - ingredient)");
        for(Ingredient i : recipe.getIngredients()){
            System.out.println("\t["+i.getId()+"]: "+ i.getAmount()+" "+i.getUnit()+" - "+i.getName());
        }
        System.out.println("Alergies: " +
                ((recipe.isVegetarian())?"v ":"")+
                ((recipe.isVegan())?"V ":"")+
                ((recipe.isGluten())?"G ":"")+
                ((recipe.isLactose())?"L ":"")+
                ((recipe.isNuts())?"N ":""));
        */
        return new ResponseEntity<List<Ingredient>>(recipe.getIngredients(), HttpStatus.OK);
    }
}
