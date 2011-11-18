package charCreator.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import charCreator.Quality;

public class QualityTest {

	String Tname1 = "Adept";
	int Tcost1 = 5;
	String Tdesc1 = "Adept blah";
	
	String Tname2 = "Elf Poser";
	int Tcost2 = -5;
	String Tdesc2 = "Elf Poser blah";
	
	Quality pos, neg, fail, pass;
	
	@Test
	public void constructorTest() {
		
		// Empty name
		try {
			fail = new Quality("", Tcost1, Tdesc1);
			Assert.fail("Empty name should fail.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Null name
		try {
			fail = new Quality(null, Tcost1, Tdesc1);
			Assert.fail("Null name should fail.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Zero cost
		try {
			fail = new Quality(Tname1, 0, Tdesc1);
			Assert.fail("Zero cost should fail.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Empty desc
		try {
			fail = new Quality(Tname1, Tcost1, "");
			Assert.fail("Empty desc should fail.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Null desc
		try {
			fail = new Quality(Tname1, Tcost1, null);
			Assert.fail("Null desc should fail.");
		} catch (Exception e) {
			// Test succeeded.
		}
		
		// Positive Quality
		try {
			pass = new Quality(Tname1, Tcost1, Tdesc1);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Positive quality should not fail.");
		}
		
		// Negative Quality
		try {
			pass = new Quality(Tname2, Tcost2, Tdesc2);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Negative quality should not fail.");
		}	
	}
	
	@Before
	public void setup() {
		// Positive Quality
		try {
			pos = new Quality(Tname1, Tcost1, Tdesc1);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Positive quality should not fail.");
		}
		
		// Negative Quality
		try {
			neg = new Quality(Tname2, Tcost2, Tdesc2);
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Negative quality should not fail.");
		}
	}

	@Test
	public void getNameTest() {
		Assert.assertEquals(Tname1, pos.getName());
		Assert.assertEquals(Tname2, neg.getName());
	}
	
	@Test
	public void getCostTest() {
		Assert.assertEquals(Tcost1, pos.getCost());
		Assert.assertEquals(Tcost2, neg.getCost());
	}
	
	@Test
	public void getDescTest() {
		Assert.assertEquals(Tdesc1, pos.getDesc());
		Assert.assertEquals(Tdesc2, neg.getDesc());
	}
}
