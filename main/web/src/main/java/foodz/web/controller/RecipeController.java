package foodz.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import foodz.entity.Recipe.Unit;
import foodz.web.service.RecipeService;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/list")
    public ModelAndView toRecipes() {
        ArrayList<Recipe> recipes = (ArrayList<Recipe>)recipeService.getRecipes();
        /*for(Recipe recipe : recipes){
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
        }*/
        return new ModelAndView("recipes", "recipes", recipes);
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable long id, ModelMap model){
        Recipe recipe = recipeService.getRecipe(id);

        model.addAttribute("pageName","edit");
        return new ModelAndView("formRecipe","recipe",recipe);
    }

    @RequestMapping("/EditRecipe")
    public String updateRecipe(@ModelAttribute("recipe")Recipe recipe){
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
        recipeService.update(recipe);
        return "redirect:/recipe/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable long id){
        recipeService.delete(id);
        return "redirect:/recipe/list";
    }

    @RequestMapping("/create")
    public ModelAndView newRecipeForm(ModelMap model){
        model.addAttribute("pageName","create");
        return new ModelAndView("formRecipe","recipe",new Recipe());
    }

    @RequestMapping("/CreateRecipe")
    public String createRecipe(@ModelAttribute("recipe")Recipe recipe){
        recipeService.save(recipe);
        return "redirect:/recipe/list";
    }

    @ResponseBody
    @GetMapping("/unit")
    public List<String> getOptions() {
        List<Unit> units = new ArrayList<Unit>(EnumSet.allOf(Unit.class));
        List<String> out = new ArrayList<String>();
        for(Unit u : units){
            out.add("{\"Enum\":\""+u+"\",\"option\":\""+u.option()+"\"}");
        }
        return out;

    }
    @ResponseBody
    @PostMapping("/post")
    public String post(@RequestBody Recipe recipe){
        System.out.println("###############[RECIPE]#################");
        System.out.println("NAME: "+recipe.getName());
        System.out.println("DESCRIPTION: "+recipe.getDescription());
        System.out.println("DIRECTIONS: "+recipe.getDirections());
        System.out.println("ID: "+recipe.getId());
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
        recipeService.save(recipe);
        return "redirect:/recipe/list";
    }

    @PostMapping("/test")
    public String test(@RequestBody String test){
        System.out.println(test);
        return "";
    }

    @ResponseBody
    @GetMapping("/allergies/{id}")
    public Map<String,Boolean> getAllergies(@PathVariable String id){
        System.out.println(id);
        return recipeService.getRecipe(Long.parseLong(id)).getAllergyMap();

    }

}
