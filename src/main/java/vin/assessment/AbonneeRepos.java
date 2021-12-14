package vin.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vin.test.model.Abonnee;


/**
 * Repository-interface om de data uit de databes te lezen en te 
 * wijzigen.
 * 
 * */
public interface AbonneeRepos extends CrudRepository<Abonnee, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO ABONNEE_CATEGORIE (abonnee_id, categorie_id, start_datum, eind_datum, prijs) VALUES (?1, ?2, ?3, ?4, ?5) ", nativeQuery=true)
	void addCategorie( Integer id, Integer cid, LocalDate sDate, LocalDate eDate, BigDecimal prijs);
	
	/** Business rule */
	@Query(value = "SELECT id FROM ABONNEE_CATEGORIE WHERE abonnee_id=?1 AND categorie_id=?2 ", nativeQuery=true)
	Integer[] abonnementBestaat( Integer id, Integer cid);
		
	
	//derived queries;
	Abonnee findByEmail(String email);
	
	boolean ingelogdTrue();
	
}
