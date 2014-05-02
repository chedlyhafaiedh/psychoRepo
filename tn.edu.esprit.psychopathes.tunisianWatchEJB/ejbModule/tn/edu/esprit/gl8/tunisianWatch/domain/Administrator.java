package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * Entity implementation class for Entity: Administrator
 * 
 */
@Entity
@Inheritance
public class Administrator extends Person implements Serializable {
	

	public Administrator(String mail, String login, String password, String type) {
		super(mail, login, password);
		this.type = type;
	}

	private String type;
	
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	public String getType() {
		return this.type;
	}

	public void setType(String role) {
		this.type = role;
	}

	

}
