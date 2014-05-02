package tn.edu.esprit.gl8.tunisianWatch.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import tn.edu.esprit.gl8.tunisianWatch.domain.Person;

@Local
@Path("/User")
public interface UserServicesLocal {
	@GET
	@Path("/addAdmin/{mail}/{login}/{password}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean addPerson(@PathParam(value = "mail") String mail,
			@PathParam(value = "login") String login,
			@PathParam(value = "password") String password);

	@GET
	@Path("/deleteAdmin/{idAdmin}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean deleteById(@PathParam(value = "idAdmin") int id);

	@GET
	@Path("/listAllAdministrators")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public List<Person> persons();

	@GET
	@Path("/authentification/{login}/{password}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean authentifierAdministrateur(
			@PathParam(value = "login") String login,
			@PathParam(value = "password") String password);

	@GET
	@Path("/findAdminByLogin/{login}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Person findAdminByLogin(@PathParam(value = "login") String login);

}
