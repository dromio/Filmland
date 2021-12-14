package vin.test.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table
public class Abonnee {

	@Id
	@Column
	private int id;

	@Column
	private String email;
	
	@Column
	private String wachtwoord;

	@Column
	@Value("false") // default
	private Boolean ingelogd;

	
	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "ABONNEE_CATEGORIE",
          joinColumns = {
	                    @JoinColumn(name = "abonnee_id", referencedColumnName = "id",
	                            nullable = false, updatable = true)},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "categorie_id", referencedColumnName = "id",
	                           nullable = false, updatable = true)})
	private Set<Categorie> categorieen = new HashSet<Categorie>();
	
	public Boolean getIngelogd() {
		return ingelogd;
	}

	public void setIngelogd(Boolean ingelogd) {
		this.ingelogd = ingelogd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
}
