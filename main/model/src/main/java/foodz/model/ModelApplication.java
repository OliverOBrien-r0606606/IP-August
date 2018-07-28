package foodz.model;

import foodz.db.RecipeRepository;
import foodz.entity.Recipe.Ingredient;
import foodz.entity.Recipe.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@EnableJpaRepositories("foodz.db")
@EntityScan({"foodz.entity.Recipe", "foodz.entity.User" })
@SpringBootApplication
public class ModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(ModelApplication.class);

	@Bean
	public CommandLineRunner demo(RecipeRepository repository) {
		return (args) -> {
			Ingredient paprika=new Ingredient("Paprika",100,"g");
			Ingredient corn =new Ingredient("Corn",1,"cup");
			ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
			ingredients.add(paprika);
			ingredients.add(corn);
			repository.save(new Recipe("test","test","test",ingredients));

			log.info(Long.toString(repository.count()));

		};
	}


}