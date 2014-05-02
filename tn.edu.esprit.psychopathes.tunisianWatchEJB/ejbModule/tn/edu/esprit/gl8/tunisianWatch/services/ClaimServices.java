package tn.edu.esprit.gl8.tunisianWatch.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl8.tunisianWatch.domain.Claim;
import tn.edu.esprit.gl8.tunisianWatch.impl.ClaimServicesLocal;

@Stateless
@LocalBean
public class ClaimServices implements ClaimServicesLocal {

	public ClaimServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addClaim(Claim claim) {
		boolean b = false;
		try {
			entityManager.persist(claim);
			b = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return b;

	}

	@Override
	public List<Claim> getAllClaims() {
		Query query = entityManager.createQuery("select a from Claim a");
		return query.getResultList();
	}

	@Override
	public boolean deleteClaim(int idclaim) {
		boolean b = false;
		try {
			Claim claim = entityManager.find(Claim.class, idclaim);
			entityManager.remove(claim);
			b = true;
		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return b;
	}

	@Override
	public List<Claim> getClaimsByMC(String mC) {
		Query query = entityManager
				.createQuery("select a from Claim a where a.location like :x");
		query.setParameter("x", "%" + mC + "%");
		return query.getResultList();
	}
}
