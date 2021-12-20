package vin.assessment;

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

import vin.assessment.model.Abonnee;

/**
 *  Request mappings voor abonnee-functionaliteit
 * 
 */

@RestController
@RequestMapping("abonnees")
public class AbonneeController {

	Logger logger = Logger.getLogger(AbonneeController.class.getName());
	
	@Autowired
	AbonneeService abonneeService;
	CategorieService categorieService;

	@GetMapping 	
	private List<Abonnee> getAbonnees() {
		return abonneeService.getAllAbonnees();
	}

	@PostMapping("/abonnee")
	private int updateAbonnee(@RequestBody Abonnee abonnee) {
		abonneeService.saveOrUpdate(abonnee);
		return abonnee.getId();
	}

	@GetMapping("/abonnee/{id}")
	private Abonnee getAbonnee(@PathVariable("id") Integer id) {
		return abonneeService.getAbonneeByid(id);
	}

	/**
	 * 
	 * @param id id van de abonnee
	 * @param cid id van de abonnementscategorie
	 */
	@RequestMapping("abonneecat/{id}/{cid}")
	private String setCategorie(@PathVariable("id") Integer id, @PathVariable("cid") Integer cid) {
	//	abonneeService.addCategorie(abonneeService.getAbonneeByid(id), categorieService.getCategorieByid(cid));
		logger.log(Level.WARN,"id="+id+"cid="+cid);
		return abonneeService.subscribe(abonneeService.getAbonneeByid(id), cid);
		
	
	}
	
	@DeleteMapping("/abonneedel/{id}")
	private void deleteAbonnee(@PathVariable("id") Integer id) {
		abonneeService.deleteAbonnee(id);
	}
}
