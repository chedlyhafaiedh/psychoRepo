package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class Authority implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAuthority;
	private String nomAuthority;
	private String adresseAuthority;
	private List<Claim> claims;

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(int idAuthority) {
		this.idAuthority = idAuthority;
	}

	public String getNomAuthority() {
		return nomAuthority;
	}

	public void setNomAuthority(String nomAuthority) {
		this.nomAuthority = nomAuthority;
	}

	public String getAdresseAuthority() {
		return adresseAuthority;
	}

	public void setAdresseAuthority(String adresseAuthority) {
		this.adresseAuthority = adresseAuthority;
	}

	@OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public void assignClaimToThoiAthority(List<Claim> claims) {
		this.setClaims(claims);
		for (Claim c : claims) {
			c.setAuthority(this);
		}
	}

}