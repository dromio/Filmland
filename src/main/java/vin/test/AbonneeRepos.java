package vin.test;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vin.test.model.Abonnee;


/**
 * Repository-interface om de data uit de databes te lezen en aan te 
 * passen.
 * 
 * */
public interface AbonneeRepos extends CrudRepository<Abonnee, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO ABONNEE_CATEGORIE (abonnee_id, categorie_id) VALUES (?1, ?2) ", nativeQuery=true)
	void addCategorie( Integer id, Integer cid);
	
	
	
	
	//derived queries;
	Abonnee findByEmail(String email);
	
	boolean ingelogdTrue();
	
}
