package vin.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Ingang applicatie.
 * 
 * @author Vincent van Doorn
 *
 */

@SpringBootApplication
@ComponentScan(basePackageClasses = { AbonneeRepos.class, CategorieRepos.class })
public class FilmlandApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmlandApplication.class, args);
	}
	
}
