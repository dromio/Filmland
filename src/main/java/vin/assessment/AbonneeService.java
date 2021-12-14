package vin.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vin.Utils;

import vin.test.model.Abonnee;
import vin.test.model.Categorie;

@Service
public class AbonneeService {

	Logger logger = Logger.getLogger(AbonneeController.class.getName());
	static BigDecimal KORTING = new BigDecimal("11");

	@Autowired
	AbonneeRepos abonneeRepos;

	@Autowired
	CategorieRepos categorieRepos;

	// output object json

	// hier
	String subscribe(Abonnee abonnee, Integer categorie_id) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Subscription", "Invalid");
		map.put("Abonnee", Integer.toString(abonnee.getId()));
		map.put("Categorie", categorie_id.toString());

		String info = " - success";
		Integer[] regels = abonneeRepos.abonnementBestaat(abonnee.getId(), categorie_id);
		if (regels == null || regels.length == 0) {
			// get maandprijs
			Optional<Categorie> O = categorieRepos.findById(categorie_id);
			if (O.isPresent()) {
				Categorie cat = O.get();
				LocalDate startDatum = LocalDate.now();
				try {
					LocalDate eindDatum = yearSubsriptionEndDate(startDatum);
					BigDecimal prijs = cat.getMaandprijs().multiply(KORTING);

					// LocalDate eindDatum = startDatum.plusYears(1);
					abonneeRepos.addCategorie(abonnee.getId(), categorie_id, startDatum, eindDatum, prijs);

					/* check tabel */
					regels = abonneeRepos.abonnementBestaat(abonnee.getId(), categorie_id);
					logger.log(Level.INFO, "Ingevoerd OK: " + (regels.length > 0));
					map.put("Subscription", "Valid");
				} catch (Exception e) {
					logger.log(Level.ERROR, "Datumberekening faalt");
					map.put("ERROR", e.getMessage());
				}
			} else {
				logger.log(Level.ERROR, "Optional-object Categorie is leeg");
			}

		} else {
			logger.log(Level.WARN, "Abonnement bestond al, geen insert");
		}
		String jSONStr = Utils.JSONObject(map);
		return jSONStr;
	};

	public List<Abonnee> getAllAbonnees() {
		List<Abonnee> abonnees = new ArrayList<Abonnee>();
		abonneeRepos.findAll().forEach(abonnee -> abonnees.add(abonnee));
		return abonnees;
	}

	public Abonnee getAbonneeByid(int id) {
		return abonneeRepos.findById(id).get();
	}

	public void deleteAbonnee(int abonneeId) {
		abonneeRepos.deleteById(abonneeId);

		// TODO delete uit koppeltabel
	}

	public void saveOrUpdate(Abonnee abonneeId) {
		abonneeRepos.save(abonneeId);
	}

	public Boolean isIngelogd(Abonnee abonnee) {
		return abonnee.getIngelogd();
	}

	private LocalDate yearSubsriptionEndDate(LocalDate startDate) throws Exception {

		LocalDate eDate = null;
		try {
			eDate = startDate.plusYears(1);

		} catch (Exception e) {
			throw new Exception("Error: cannot calculate endDate");
		}

		return eDate;
	}
}
