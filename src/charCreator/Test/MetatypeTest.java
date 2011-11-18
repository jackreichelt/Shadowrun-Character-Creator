package charCreator.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import charCreator.metatype;

public class MetatypeTest {

	String Tname = "Human";
	int Tcost = 0;
	int[] Tmins = {1, 1, 1, 1, 1, 1, 1, 1, 2};
	int[] Tmaxs = {6, 6, 6, 6, 6, 6, 6, 6, 7};
	String Tnotes = "";
	
	metatype Human, failure, pass;
	
	@Test
	public void constructorTest() {
		// Invalid name test 1
		try {
			failure = new metatype("", Tcost, Tmins, Tmaxs, Tnotes);
			Assert.fail("Empty name should error.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Invalid name test 2
		try {
			failure = new metatype(null, Tcost, Tmins, Tmaxs, Tnotes);
			Assert.fail("Null name should error.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Invalid cost test
		try {
			failure = new metatype(Tname, -10, Tmins, Tmaxs, Tnotes);
			Assert.fail("Negative cost should error.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Invalid ranges test
		try {
			failure = new metatype(Tname, Tcost, Tmaxs, Tmins, Tnotes);
			Assert.fail("Bad ranges should error.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Negative mins test
		try {
			int[] bad = {1, -1, 1, 1, 1, 1, 1, 1, 2};
			failure = new metatype(Tname, Tcost, bad, Tmaxs, Tnotes);
			Assert.fail("Negative minimum should error.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Null Tnotes test.
		try {
			String nullString = null;
			pass = new metatype(Tname, Tcost, Tmins, Tmaxs, nullString);
			Assert.assertEquals("", pass.getNotes());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			Assert.fail("null notes should not error: ");
		}
		
		// Success test.
		try {
			pass = new metatype(Tname, Tcost, Tmins, Tmaxs, Tnotes);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Before
	public void setUp() {
		try {
			Human = new metatype(Tname, Tcost, Tmins, Tmaxs, Tnotes);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void getAttribMinTest() {
		// TODO implement test.
	}
	
	@Test
	public void getAttribMaxTest() {
		// TODO implement test.
	}
	
	@Test
	public void getCostTest() {
		Assert.assertEquals(0, Human.getCost());
	}
	
	@Test
	public void getNameTest() {
		Assert.assertEquals("Human", Human.getName());
	}
	
	@Test
	public void getNotesTest() {
		Assert.assertEquals("", Human.getNotes());
	}
	
	

}
