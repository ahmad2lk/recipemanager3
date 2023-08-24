package recipemanager.projekt.recipemanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import recipemanager.projekt.recipemanager.user.model.Role;
import recipemanager.projekt.recipemanager.user.model.User;


import java.util.ArrayList;

@SpringBootApplication
public class RecipemanagerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RecipemanagerApplication.class);
		app.setAllowBeanDefinitionOverriding(true);
		app.run(args);
	}


}
