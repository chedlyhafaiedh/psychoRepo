package tn.edu.esprit.gl8.tunisianWatch.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl8.tunisianWatch.domain.Administrator;
import tn.edu.esprit.gl8.tunisianWatch.domain.Person;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesLocal;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPerson(Person person) {
		entityManager.persist(person);

	}

	@Override
	public void deleteUser(Person person) {
		entityManager.remove(entityManager.merge(person));

	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);

	}

	@Override
	public Person getPersonById(int idPerson) {
		Person person = entityManager.find(Person.class, idPerson);
		return person;

	}

	@Override
	public Person login(String login, String password) {
		String jpql = "select u from Person u where u.login = :param1 and u.password= :param2";
		Query query = entityManager.createQuery(jpql);
		Person userFound = new Person();
		query.setParameter("param1", login);
		query.setParameter("param2", password);

		try {
			userFound = (Person) query.getSingleResult();

		} catch (Exception e) {
			userFound = null;
		}

		return userFound;
	}

	@Override
	public boolean addPerson(String mail, String login, String password) {
		boolean b = false;
		try {
			entityManager.persist(new Administrator(mail, login, password,
					"normal"));
			b = true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;

	}

	@Override
	public boolean deleteById(int id) {
		boolean b = false;
		try {
			Person person = entityManager.find(Person.class, id);
			entityManager.remove(person);
			b = true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public List<Person> persons() {
		Query query = entityManager.createQuery("select a from Person a");
		return query.getResultList();

	}

	@Override
	public boolean authentifierAdministrateur(String login, String password) {

		boolean b = false;
		try {
			Query query = entityManager
					.createQuery("select e from Person e where e.login=:login and e.password=:password");

			query.setParameter("login", login);
			query.setParameter("password", password);
			Person person = (Person) query.getSingleResult();
			b = true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;
	}

	@Override
	public Person findAdminByLogin(String login) {
		Query query = entityManager
				.createQuery("select a from Person a where a.login=:login");
		query.setParameter("login", login);

		return (Person) query.getSingleResult();
	}
}
