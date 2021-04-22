package BIanca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class JunitAssertTest {
	@Test
	public void twoPlustwoEqual4() {
		assertEquals(4,2+2);
		
	}
	
	@Test
	public void twoPlustwoEqualsFour() {
		assertEquals("2 + 2 = 4", 4,2+2);
	}
	
	boolean result = true;
	
	@Test
	public void testingAssetTrue() {
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testingAssertTrueWithDescription() {
		assertTrue("Result is true", !result);
		
	}

}
