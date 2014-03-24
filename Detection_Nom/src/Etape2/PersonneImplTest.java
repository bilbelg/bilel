package Etape2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonneImplTest {
	
	PersonneImpl underTest= new PersonneImpl();
    String text="Bilel Belgacem";
    String text2="Mr Bilel Belgacem";
    String text3="Mr.Bilel Belgacem";
    String text4="Mr Bilel Belkacem";
    Personne2 pers;
	@Test
	public void test() {
		
		pers=underTest.PersonFromTxt("Bilel Belgacem");
		assertEquals(pers.getFirstName(),"Bilel");
		assertEquals(pers.getLastName(),"Belgacem");
	}

	@Test
	public void test2() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Bilel Belgacem");
		assertEquals(0,pourcent);
	}
	
	@Test
	public void test3() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Mr Bilel Belgacem");
		assertEquals(0,pourcent);
	}
	
	@Test
	public void test4() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Mr.Bilel Belgacem");
		assertEquals(0,pourcent);
	}
	
	@Test
	public void test5() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Mr Bilel Belkacem");
		assertEquals(1,pourcent);
	}
	
	@Test
	public void test6() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Mr.Belgacem");
		assertEquals(-10,pourcent);
	}
	@Test
	public void test7() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Mr.Belkacem");
		assertEquals(-11,pourcent);
	}
}
