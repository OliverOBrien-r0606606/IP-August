package foodz.entity.Recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    @Column(name = "id")
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(256)")
    private String name;
    @Column(name = "directions", columnDefinition = "VARCHAR(8000)")
    private String directions;
    @Column(name = "description", columnDefinition = "VARCHAR(512)")
    private String description;

    public boolean isVegetarian() {

        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    public boolean isLactose() {
        return lactose;
    }

    public void setLactose(boolean lactose) {
        this.lactose = lactose;
    }

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private boolean vegetarian;
    private boolean vegan;
    private boolean gluten;
    private boolean lactose;
    private boolean nuts;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String,Boolean> getAllergyMap(){
        Map<String, Boolean> allergyMap = new HashMap<String, Boolean>();
        allergyMap.put("vegetarian",isVegetarian());
        allergyMap.put("vegan",isVegan());
        allergyMap.put("gluten",isGluten());
        allergyMap.put("lactose",isLactose());
        allergyMap.put("nuts",isNuts());
        return allergyMap;
    }


    public Recipe(String name, String directions, String description, boolean vegetarian, boolean vegan, boolean gluten, boolean lactose, boolean nuts, List<Ingredient> ingredients) {
        this.name = name;
        this.directions = directions;
        this.description = description;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.gluten = gluten;
        this.lactose = lactose;
        this.nuts = nuts;
        this.ingredients = ingredients;
    }
    public Recipe( String name, String directions, String description, ArrayList<Ingredient> ingredients) {

        setDescription(description); setDirections(directions);  setName(name); setIngredients(ingredients);
    }

    public Recipe() {

    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directions='" + directions + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", gluten=" + gluten +
                ", lactose=" + lactose +
                ", nuts=" + nuts +
                ", ingredients=" + ingredients +
                '}';
    }
}
