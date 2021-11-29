package vin.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import vin.test.*;

//@ComponentScan(basePackageClasses = CategorieController.class)
//@ComponentScan(basePackageClasses = { CategorieController.class, AbonneeController.class })

@SpringBootApplication
@ComponentScan(basePackageClasses = { AbonneeRepos.class, CategorieRepos.class })
public class FilmlandApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmlandApplication.class, args);
	}

	
}
