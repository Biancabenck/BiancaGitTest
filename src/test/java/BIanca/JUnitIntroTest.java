package BIanca;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitIntroTest {
	
	@Test
	public void learningTesTAnnotation() {
		System.out.println("Test1");
	}
	@Test
	public void learningTestAnnotaiton2() {
		System.out.println("Test2");
	}
	@Test
	public void learningTestAnnotaiton3() {
		System.out.println("Test3");
	}
	@Before
	public void beforeAnnotation() {
		System.out.println("Create connection!!!");
	}
	@After
	public void afterAnnotation() {
		System.out.println("close connection");
	}
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("---------");
		System.out.println("Before Class");
		System.out.println("---------");
	}
	
	@AfterClass
	public static void testAfterClass() {
		System.out.println("---------");
		System.out.println("After Class");
		System.out.println("---------");
	}
	

}
