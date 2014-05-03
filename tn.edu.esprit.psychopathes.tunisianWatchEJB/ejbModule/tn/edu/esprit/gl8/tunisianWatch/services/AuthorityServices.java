package tn.edu.esprit.gl8.tunisianWatch.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl8.tunisianWatch.domain.Authority;
import tn.edu.esprit.gl8.tunisianWatch.impl.AuthorityServicesLocal;
import tn.edu.esprit.gl8.tunisianWatch.impl.AuthorityServicesRemote;

/**
 * Session Bean implementation class AuthorityServices
 */
@Stateless

public class AuthorityServices implements AuthorityServicesLocal, AuthorityServicesRemote {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public AuthorityServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Authority> getAllAuthorities() {
		Query query = entityManager.createQuery("select a from Authority a");
		return query.getResultList();
	}

	@Override
	public boolean deleteAuthority(int idAuth) {
		boolean b = false;
		try {
			Authority authority = entityManager.find(Authority.class, idAuth);
			entityManager.remove(authority);
			b = true;
		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return b;
	}

	@Override
	public List<Authority> consulAuthoritiesMC(String motCle) {
		Query query = entityManager
				.createQuery("select a from Authority a where a.nomAuthority like :x");
		query.setParameter("x", "%" + motCle + "%");
		return query.getResultList();
	}

	@Override
	public boolean insertAuthority(Authority authority) {
		boolean b = false;
		try {
			entityManager.persist(authority);
			b = true;
		} catch (Exception e) {
			System.out.println("errrr");
			
		}
		return b;
	}

	@Override
	public boolean addAuthority(String nomAuth, String adresseAuth) {
		// TODO Auto-generated method stub
		return false;
	}
}
