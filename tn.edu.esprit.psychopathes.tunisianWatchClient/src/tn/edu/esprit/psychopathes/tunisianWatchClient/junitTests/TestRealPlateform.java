package tn.edu.esprit.psychopathes.tunisianWatchClient.junitTests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.gl8.tunisianWatch.domain.Authority;
import tn.edu.esprit.gl8.tunisianWatch.domain.Claim;
import tn.edu.esprit.gl8.tunisianWatch.impl.AuthorityServicesRemote;
import tn.edu.esprit.gl8.tunisianWatch.impl.ClaimServicesRemote;

public class TestRealPlateform {

	private Context context;
	private AuthorityServicesRemote authorityServicesRemote;

	private ClaimServicesRemote claimServicesRemote;

	@Before
	public void test() {
		try {
			context = new InitialContext();
			authorityServicesRemote = (AuthorityServicesRemote) context
					.lookup("ejb:tn.edu.esprit.psychopathes.tunisianWatch/tn.edu.esprit.psychopathes.tunisianWatchEJB/AuthorityServices!tn.edu.esprit.gl8.tunisianWatch.impl.AuthorityServicesRemote");
			claimServicesRemote = (ClaimServicesRemote) context
					.lookup("ejb:tn.edu.esprit.psychopathes.tunisianWatch/tn.edu.esprit.psychopathes.tunisianWatchEJB/ClaimServices!tn.edu.esprit.gl8.tunisianWatch.impl.ClaimServicesRemote");

		} catch (Exception e) {
			System.out.println("errrrrrrr");
		}

	}

	@Test
	public void itShouldAssaignClaimToAuth(){
		Claim claim= new Claim();
		claim.setDate("24/12/2013");
		claim.setDescription("RAS");
		claim.setLat(31.2548);
		claim.setLng(32.54896);
		claim.setStatut("TER");
		claim.setType("routiere");
		
		Claim claim2= new Claim();
		claim2.setDate("25/12/2013");
		claim2.setDescription("RAS");
		claim2.setLat(10.2548);
		claim2.setLng(31.54896);
		claim2.setStatut("NN");
		claim2.setType("Inf");
		
		Authority authority= new Authority();
		authority.setNomAuthority("Tunis");
		authority.setAdresseAuthority("Kasba");
		List<Claim>claims= new ArrayList<Claim>();
		claims.add(claim);
		claims.add(claim2);
		authority.assignClaimToThoiAthority(claims);
		
		
		
		
		
		
		Assert.assertTrue(authorityServicesRemote.insertAuthority(authority));
		
	}
}
