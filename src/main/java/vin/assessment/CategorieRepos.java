package vin.assessment;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vin.assessment.model.Categorie;

/**
 * Repository-interface om abonnement-categorieen uit de database op te halen
 * 
 */
public interface CategorieRepos extends CrudRepository<Categorie, Integer>{

	// gebruik JPQL native
	@Query(value="SELECT * FROM ABONNEE_CATEGORIE AC, CATEGORIE C WHERE AC.CATEGORIE_ID=C.ID ", nativeQuery=true)
	List<Categorie> getSubscribedCategories();
	
	@Query(value="SELECT * FROM CATEGORIE C WHERE AC.CATEGORIE_ID=?1 ", nativeQuery=true)
	List<Categorie> getCategory(Integer id);
	
}
