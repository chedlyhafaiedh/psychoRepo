package tn.edu.esprit.gl8.tunisianWatch.impl;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.tunisianWatch.domain.Citizen;

@Remote
public interface CitizenServicesRemote {

	public boolean insertCitizen(Citizen citizen);
}
