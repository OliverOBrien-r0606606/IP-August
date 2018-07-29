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
@EntityScan({"foodz.entity.Recipe", "foodz.entity" })
@SpringBootApplication
public class ModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(ModelApplication.class);


}