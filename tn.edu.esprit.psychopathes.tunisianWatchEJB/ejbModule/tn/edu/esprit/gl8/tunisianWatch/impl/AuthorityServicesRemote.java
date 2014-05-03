package tn.edu.esprit.gl8.tunisianWatch.impl;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.tunisianWatch.domain.Authority;

@Remote
public interface AuthorityServicesRemote {

	public boolean insertAuthority(Authority authority);
}
