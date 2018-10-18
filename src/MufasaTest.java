import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class MufasaTest {

	Mufasa testAccounts;
	MufasaRepository exampleX;
	
	@Before
	public void setup(){
		//sqatPortfolio = new Portfolio();
		//sqatPortfolio.setName("SQaTLab Portfolio");
		
		MufasaRepository testAccounts = MufasaRepository.getInstance();
		testAccounts.addMufasa( new Mufasa("firstName", "lastName", "username", "password", 42) );
		
		//Mock create
		exampleX= EasyMock.createMock(MufasaRepository.class);//what does this do?
		testAccounts.tulosta();
	}

	@Test //verifying external dependency
	public void theAwesomeLifeOfStudents() {
		//Mock set expectations
		EasyMock.expect(testAccounts.getFirstName()).andStubReturn("firstName"); //recording the expected behaviour
		EasyMock.replay(testAccounts); //activating the expected behaviour
		Mufasa paska = new Mufasa("firstName", "testname2", "testname3", "password123", 23);
		exampleX.addMufasa(paska);
		assertEquals("firstName", testAccounts.getFirstName()); 
		
		//I have no clue what I am doing here as you might see
		
	}
}
