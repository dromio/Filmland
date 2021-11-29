package vin.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table
public class AbonneeBU {

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
