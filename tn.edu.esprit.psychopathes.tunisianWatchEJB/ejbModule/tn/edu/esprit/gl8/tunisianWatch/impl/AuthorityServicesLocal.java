package tn.edu.esprit.gl8.tunisianWatch.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.edu.esprit.gl8.tunisianWatch.domain.Authority;

@Local
@Path("/Authority")
public interface AuthorityServicesLocal {
	@GET
	@Path("/addAuth/{nomAuth}/{adresseAuth}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean addAuthority(@PathParam(value = "nomAuth") String nomAuth,
			@PathParam(value = "adresseAuth") String adresseAuth);

	@GET
	@Path("/listAllAuthorities")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public List<Authority> getAllAuthorities();

	@GET
	@Path("/deleteById/{idAuth}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean deleteAuthority(@PathParam(value = "idAuth")int idAuth);

	@GET
	@Path("/consultByMC/{motCle}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Authority> consulAuthoritiesMC(
			@PathParam(value = "motCle") String motCle);

}
