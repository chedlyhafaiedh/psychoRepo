package tn.edu.esprit.gl8.tunisianWatch.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl8.tunisianWatch.domain.Citizen;
import tn.edu.esprit.gl8.tunisianWatch.impl.CitizenServicesLocal;
import tn.edu.esprit.gl8.tunisianWatch.impl.CitizenServicesRemote;

/**
 * Session Bean implementation class CitizenServices
 */
@Stateless
public class CitizenServices implements CitizenServicesRemote, CitizenServicesLocal {

	
	
	
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CitizenServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean insertCitizen(Citizen citizen) {
		boolean b = false;
		try {
			entityManager.persist(citizen);
			b = true;
		} catch (Exception e) {
			System.out.println("errrr");
			
		}
		return b;
	}

}
