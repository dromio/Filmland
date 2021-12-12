package vin.test;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vin.test.model.Categorie;

@RestController
public class CategorieController {

	
	Logger logger = Logger.getLogger(CategorieController.class.getName());

	@Autowired
	CategorieService categorieService;

	//Handler methhods
	//@GetMapping
	@RequestMapping("/categorieen")
	private List<Categorie> getCategories() {
		logger.log(Level.INFO,"getCategories entered");
		return categorieService.getAllCategorieen();
	}
	
	
	@RequestMapping("/subscribedcategorieen")
	private List<Categorie> getSubscribedCategorieen(){
		logger.log(Level.INFO,"getSubscribedCategorieen entered");

		return categorieService.getSubscribedCategorieen();
	}
	
	@PostMapping("/categorie")
	private int updateCategorie(@RequestBody Categorie categorie) {
		categorieService.saveOrUpdate(categorie);
		return categorie.getId();
	}

	@GetMapping("/categorie/{id}")
	private Categorie getCategorie(@PathVariable("id") Integer id) {
		return categorieService.getCategorieByid(id);
	}

	@DeleteMapping("/categoriedel/{id}")
	private void deleteCategorie(@PathVariable("id") Integer id) {
		categorieService.deleteCategorie(id);
	}

}
