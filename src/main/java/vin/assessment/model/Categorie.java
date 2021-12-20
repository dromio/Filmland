package vin.assessment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity mapping van de abonnement-tabel
 * 
 */

@Entity
@Table
public class Categorie implements Serializable {
 
	private static final long serialVersionUID = 589431L;

	@Id
	@Column
	private int id;

	@Column
	private String titel;
	
	@Column
	private BigDecimal maandprijs;
	@ManyToMany(mappedBy = "categorieen", fetch = FetchType.LAZY)
	private Set<Abonnee> abonnees = new HashSet<Abonnee>();
	
	public BigDecimal getMaandprijs() {
		return maandprijs;
	}

    public void setMaandprijs(BigDecimal maandprijs) {
		this.maandprijs = maandprijs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

}
