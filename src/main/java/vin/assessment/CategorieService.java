package vin.assessment;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vin.assessment.model.Categorie;

@Service
public class CategorieService {

	Logger logger = Logger.getLogger(CategorieService.class.getName());

	@Autowired
	CategorieRepos categorieRepos;

	public List<Categorie> getSubscribedCategorieen(){
		logger.log(Level.INFO,"getSubscribedCategorieen entered");
		List<Categorie> categorieen = new ArrayList<Categorie>();
		categorieRepos.getSubscribedCategories().forEach(categorie->categorieen.add(categorie));
		if (categorieen.size()== 0) {
			logger.log(Level.WARN,"Geen abonnementen");
		}
		return categorieen;
	}

	public List<Categorie> getAllCategorieen(){
		List<Categorie> categorieen = new ArrayList<Categorie>();
		categorieRepos.findAll().forEach(categorie->categorieen.add(categorie));
		return categorieen;
	}
	
	public Categorie getCategorieByid(int id) {
		return categorieRepos.findById(id).get();
	}
	
	public void deleteCategorie(int categorieId ) {
		categorieRepos.deleteById(categorieId);
		
		// TODO delete uit koppeltabel (cascading)
	}
	
	public void saveOrUpdate(Categorie categorieId) {
		categorieRepos.save(categorieId);
	}
	
	
}
