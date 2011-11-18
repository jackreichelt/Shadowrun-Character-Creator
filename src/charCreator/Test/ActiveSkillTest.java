package charCreator.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import charCreator.ActiveSkill;
import charCreator.Attribute;

public class ActiveSkillTest {

	String Tname = "Pistols";
	Attribute Tattrib = Attribute.AGI;
	
	ActiveSkill pistols, pass, fail;
	
	@Test
	public void constructorTest() {
		
		// Empty name
		try {
			fail = new ActiveSkill("", Tattrib);
			Assert.fail("Empty name should fail.");
		} catch (Exception e) {
			// Test passed.
		}
		
		// Null name
		try {
			fail = new ActiveSkill(null, Tattrib);
			Assert.fail("Null name should fail.");
		} catch (Exception e) {
			// Test passed.
		}
		
		// Null attrib
		try {
			fail = new ActiveSkill(Tname, null);
			Assert.fail("Null attrib should fail.");
		} catch (Exception e) {
			// Test passed.
		}
		
		// Correct
		try {
			pass = new ActiveSkill(Tname, Tattrib);
			// Test passed
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Failure. See console.");
		}
	}
	
	@Before
	public void setup() {
		try {
			pistols = new ActiveSkill(Tname, Tattrib);
			// Test passed
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			Assert.fail("Failure. See console.");
		}
	}
	
	@Test
	public void getNameTest() {
		Assert.assertEquals(Tname, pistols.getName());
	}
	
	@Test
	public void getAttribTest() {
		Assert.assertEquals(Tattrib, pistols.getAttrib());
	}
	
	@Test
	public void toStringTest() {
		Assert.assertEquals("Pistols", pistols.toString());
	}

}
