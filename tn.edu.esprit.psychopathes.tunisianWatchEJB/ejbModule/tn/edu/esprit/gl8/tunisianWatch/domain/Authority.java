package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authorities")
public class Authority implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAuthority;
	private String nomAuthority;
	private String adresseAuthority;

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(String nomAuthority, String adresseAuthority) {
		super();
		this.nomAuthority = nomAuthority;
		this.adresseAuthority = adresseAuthority;
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

}