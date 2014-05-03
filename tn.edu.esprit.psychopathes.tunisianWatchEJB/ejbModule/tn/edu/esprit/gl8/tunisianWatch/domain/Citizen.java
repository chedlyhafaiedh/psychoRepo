package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Citizen
 * 
 */
@Entity
public class Citizen implements Serializable {

	private int idCitizen;
	private String nomCitizen;
	private String prenomCitizen;
	private String adressCitizen;
	private String loginCitizen;
	private String pwdCitizen;
	private int ageCitizen;
	private static final long serialVersionUID = 1L;

	private List<Claim> claims;

	public Citizen() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCitizen() {
		return this.idCitizen;
	}

	public void setIdCitizen(int idCitizen) {
		this.idCitizen = idCitizen;
	}

	public String getNomCitizen() {
		return this.nomCitizen;
	}

	public void setNomCitizen(String nomCitizen) {
		this.nomCitizen = nomCitizen;
	}

	public String getPrenomCitizen() {
		return this.prenomCitizen;
	}

	public void setPrenomCitizen(String prenomCitizen) {
		this.prenomCitizen = prenomCitizen;
	}

	public String getAdressCitizen() {
		return this.adressCitizen;
	}

	public void setAdressCitizen(String adressCitizen) {
		this.adressCitizen = adressCitizen;
	}

	public String getLoginCitizen() {
		return this.loginCitizen;
	}

	public void setLoginCitizen(String loginCitizen) {
		this.loginCitizen = loginCitizen;
	}

	public String getPwdCitizen() {
		return this.pwdCitizen;
	}

	public void setPwdCitizen(String pwdCitizen) {
		this.pwdCitizen = pwdCitizen;
	}

	public int getAgeCitizen() {
		return this.ageCitizen;
	}

	public void setAgeCitizen(int ageCitizen) {
		this.ageCitizen = ageCitizen;
	}

	@OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	
	public void assignClaimToToThisCitizen(List<Claim> claims) {
		this.setClaims(claims);
		for (Claim c : claims) {
			c.setCitizen(this);
		}
	}

}
