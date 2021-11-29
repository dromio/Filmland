package vin.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vin.test.model.Abonnee;

@Service
public class AbonneeService {

	@Autowired
	AbonneeRepos abonneeRepos;

//hier	
//	void addCategorie(Abonnee abonnee, Categorie categorie) {
	void addCategorie(Abonnee abonnee, Integer categorie_id) {
//		abonneeRepos.addCategorie(abonnee.getId(), categorie.getId());
		abonneeRepos.addCategorie(abonnee.getId(), categorie_id);

	};
	
	public List<Abonnee> getAllAbonnees(){
		List<Abonnee> abonnees= new ArrayList<Abonnee>();
		abonneeRepos.findAll().forEach(abonnee->abonnees.add(abonnee));
		return abonnees;
	}
	
	public Abonnee getAbonneeByid(int id) {
		return abonneeRepos.findById(id).get();
	}
	
	public void deleteAbonnee(int abonneeId ) {
		abonneeRepos.deleteById(abonneeId);
		
		// TODO delete uit koppeltabel
	}
	
	public void saveOrUpdate(Abonnee abonneeId) {
		abonneeRepos.save(abonneeId);
	}
	
	public Boolean isIngelogd(Abonnee abonnee) {
		return abonnee.getIngelogd();
	}
	
}
