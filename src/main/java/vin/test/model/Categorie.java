package vin.test.model;

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
// unknown target entity property: vin.test.model.Abonnee.Categorie in vin.test.model.Categorie.abonnees	
	@ManyToMany(mappedBy = "categorieen", fetch = FetchType.LAZY)
	private Set<Abonnee> abonnees = new HashSet<Abonnee>();
	
//	@ManyToOne (fetch = FetchType.EAGER)
//	@JoinColumn(name = "abonnee_id")
//	private Abonnee abonnee;

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

//
//	public BigDecimal getMaandPrijs() {
//		return maandprijs;
//	}

//
//	public void setMaandPrijs(BigDecimal maandPrijs) {
//		this.maandprijs = maandPrijs;
//	}

}
