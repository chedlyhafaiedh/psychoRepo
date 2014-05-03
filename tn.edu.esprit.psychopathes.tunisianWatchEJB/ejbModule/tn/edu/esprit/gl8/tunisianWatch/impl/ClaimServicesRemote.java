package tn.edu.esprit.gl8.tunisianWatch.impl;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.tunisianWatch.domain.Claim;

@Remote
public interface ClaimServicesRemote {
	public void insertClaim(Claim claim);

}
