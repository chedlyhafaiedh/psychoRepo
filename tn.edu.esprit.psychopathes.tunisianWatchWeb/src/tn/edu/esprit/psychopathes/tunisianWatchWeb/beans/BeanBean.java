package tn.edu.esprit.psychopathes.tunisianWatchWeb.beans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.gl8.tunisianWatch.domain.Claim;
import tn.edu.esprit.gl8.tunisianWatch.impl.ClaimServicesLocal;

@ManagedBean(name = "beanbean")
@ViewScoped
public class BeanBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Claim> claims;
	@EJB
	private ClaimServicesLocal claimServicesLocal;
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	@PostConstruct
	public void init() {
		claims=claimServicesLocal.getAllClaims();
	}
	
	
	
	
	
	
}