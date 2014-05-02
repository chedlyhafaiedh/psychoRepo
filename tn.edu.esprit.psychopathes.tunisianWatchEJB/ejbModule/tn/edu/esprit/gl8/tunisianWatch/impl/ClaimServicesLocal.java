package tn.edu.esprit.gl8.tunisianWatch.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import tn.edu.esprit.gl8.tunisianWatch.domain.Claim;

@Local
@Path("/Claim")
public interface ClaimServicesLocal {

	@GET
	@Path("/addClaim/{location}/{priority}/{description}/{direction}/{statut}/{date}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean addClaim(Claim claim);

	@GET
	@Path("/listAllClaims")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public List<Claim> getAllClaims();

	@GET
	@Path("/deleteClaim/{idclaim}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public boolean deleteClaim(@PathParam(value = "idclaim") int idclaim);

	@GET
	@Path("/findClaim/{location}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public List<Claim> getClaimsByMC(@PathParam(value = "location") String mC);
}
