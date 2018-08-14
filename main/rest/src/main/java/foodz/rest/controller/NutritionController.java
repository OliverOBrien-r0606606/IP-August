package foodz.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import foodz.db.RecipeRepository;
import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import foodz.rest.entity.Food;
import foodz.rest.entity.Nutrition;
import foodz.rest.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.json.JsonObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@ComponentScan("foodz.db")
public class NutritionController {

    final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Environment env;

    @Autowired
    private RecipeService service;

    @RequestMapping("/nutrition")
    public ResponseEntity<?> getNutrition(@RequestBody RecipeDTO id){
        StringBuilder query = new StringBuilder();
        ResponseDTO responseDTO = new ResponseDTO(service.getRecipe(id.getId()));
        responseDTO.recipe.getIngredients().forEach( i -> query.append(i));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-app-id", env.getProperty("nutrition.id"));
        headers.set("x-app-key", env.getProperty("nutrition.key"));

        RestTemplate restTemplate = new RestTemplate();

        FoodsDTO foods =
                restTemplate.exchange(env.getProperty("nutrition.url"),
                        HttpMethod.POST,
                        new HttpEntity<>(
                                "{ \"query\":\""+query+"\"}",
                                headers),
                        FoodsDTO.class)
                            .getBody();

        foods.foods.forEach( i -> responseDTO.nutrition.addNutrition(i));


        System.out.println(responseDTO.out());


        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /*
    @PostMapping("/recipe")
    public ResponseEntity<List<Ingredient>> getRecipe(@RequestBody RecipeDTO dto){
        System.out.println(dto);

        Recipe recipe = service.getRecipe(dto.getId());

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

        return new ResponseEntity<List<Ingredient>>(recipe.getIngredients(), HttpStatus.OK);
    }
    */
}

class FoodsDTO {
    public List<Food> foods;

    public FoodsDTO(){}
}

class ResponseDTO{
    public Nutrition nutrition; public Recipe recipe;

    public ResponseDTO(Recipe recipe) {
        this.recipe = recipe;
        this.nutrition = new Nutrition();
    }

    public String out(){
        return "Recipe:\n"+
                recipe+
                "\n##################\n"+
                "Nutrition:\n"+
                nutrition;
    }
}




class RecipeDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeDTO() {

    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                '}';
    }
}
