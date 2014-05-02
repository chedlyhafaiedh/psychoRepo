package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Claim implements Serializable {

	/**
	 * 
	 */
	private int idclaim;
	private String location;
	private String priority;
	private String description;
	private String direction;
	private String statut;
	private String date;
	private static final long serialVersionUID = 1L;

	/*
	 * private int idclaim;
	 * 
	 * @Column(name = "description") private String description;
	 * 
	 * @Column(name = "location") private String location;
	 * 
	 * @Column(name = "direction") private String direction;
	 * 
	 * @Column(name = "statut") private String statut;
	 * 
	 * @Column(name = "priority") private String priority;
	 * 
	 * @Column(name = "date") private String date;
	 * 
	 * // @ManyToOne // private User user;
	 * 
	 * @ManyToOne // private Categorie categorie; //
	 * 
	 * @OneToMany(mappedBy="claim") // private java.util.List<Categorie>
	 * categories;
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdclaim() {
		return idclaim;
	}

	public void setIdclaim(int idclaim) {
		this.idclaim = idclaim;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	// public User getUser() {
	// return user;
	// }

	// public void setUser(User user) {
	// this.user = user;
	// }

	public Claim(int idclaim, String description, String location,
			String direction, String statut, String priority, String date) {
		super();
		this.idclaim = idclaim;
		this.description = description;
		this.location = location;
		this.direction = direction;
		this.statut = statut;
		this.priority = priority;
		this.date = date;
		// this.user = user;
	}

	public Claim(String description, String location, String direction,
			String statut, String priority, String date) {
		super();

		this.description = description;
		this.location = location;
		this.direction = direction;
		this.statut = statut;
		this.priority = priority;
		this.date = date;

	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

}